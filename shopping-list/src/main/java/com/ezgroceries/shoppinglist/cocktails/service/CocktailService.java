package com.ezgroceries.shoppinglist.cocktails.service;

import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBClient;
import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBResponse;
import com.ezgroceries.shoppinglist.cocktails.database.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.cocktails.database.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    private CocktailDBClient cocktailDBClient;

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailDBClient cocktailDBClient, CocktailRepository cocktailRepository) {
        this.cocktailDBClient = cocktailDBClient;
        this.cocktailRepository = cocktailRepository;
    }

    public CocktailResource getCocktail(UUID cocktailId) {
        CocktailEntity cocktailEntity = this.cocktailRepository.findById(cocktailId);

        return  new CocktailResource(cocktailEntity.getId(),
                cocktailEntity.getName(),
                cocktailEntity.getGlass(),
                cocktailEntity.getInstructions(),
                cocktailEntity.getImageLink(),
                new ArrayList<>(cocktailEntity.getIngredients()));
   }

    public List<CocktailResource> getCocktails(String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);

        return mergeCocktails(cocktailDBResponse.getDrinks());
    }

    public List<CocktailResource> mergeCocktails(List<CocktailDBResponse.DrinkResource> drinks) {
        //Get all the idDrink attributes
        List<String> ids = drinks.stream().map(CocktailDBResponse.DrinkResource::getIdDrink).collect(Collectors.toList());

        //Get all the ones we already have from our DB, use a Map for convenient lookup
        Map<String, CocktailEntity> existingEntityMap = cocktailRepository.findByIdDrinkIn(ids).stream().collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Stream over all the drinks, map them to the existing ones, persist a new one if not existing
        Map<String, CocktailEntity> allEntityMap = drinks.stream().map(drinkResource -> {
            CocktailEntity cocktailEntity = existingEntityMap.get(drinkResource.getIdDrink());
            if (cocktailEntity == null) {
                CocktailEntity newCocktailEntity = new CocktailEntity();
                newCocktailEntity.setId(UUID.randomUUID());
                newCocktailEntity.setIdDrink(drinkResource.getIdDrink());
                newCocktailEntity.setName(drinkResource.getStrDrink());
                newCocktailEntity.setIngredients(drinkResource.getIngredients());
                newCocktailEntity.setGlass(drinkResource.getStrGlass());
                newCocktailEntity.setImageLink(drinkResource.getStrDrinkThumb());
                newCocktailEntity.setInstructions(drinkResource.getStrInstructions());
                newCocktailEntity.setIngredients(drinkResource.getAllIngredients());
                cocktailEntity = cocktailRepository.save(newCocktailEntity);
            }
            return cocktailEntity;
        }).collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Merge drinks and our entities, transform to CocktailResource instances
        return mergeAndTransform(drinks, allEntityMap);
    }

    private List<CocktailResource> mergeAndTransform(List<CocktailDBResponse.DrinkResource> drinks, Map<String, CocktailEntity> allEntityMap) {
        return drinks.stream().map(drinkResource -> new CocktailResource(allEntityMap.get(drinkResource.getIdDrink()).getId(), drinkResource.getStrDrink(), drinkResource.getStrGlass(),
                drinkResource.getStrInstructions(), drinkResource.getStrDrinkThumb(), drinkResource.getIngredients())).collect(Collectors.toList());
    }
}

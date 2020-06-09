package com.ezgroceries.shoppinglist.shoppinglists.service;

import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import com.ezgroceries.shoppinglist.cocktails.service.CocktailService;
import com.ezgroceries.shoppinglist.shoppinglists.database.entities.CocktailShoppingListEntity;
import com.ezgroceries.shoppinglist.shoppinglists.database.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.shoppinglists.database.repositories.CocktailShoppingListRepository;
import com.ezgroceries.shoppinglist.shoppinglists.database.repositories.ShoppingListRepository;
import com.ezgroceries.shoppinglist.shoppinglists.model.ShoppingListResource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final CocktailShoppingListRepository cocktailShoppingListRepository;

    private final CocktailService cocktailService;

    public ShoppingListService(
            ShoppingListRepository shoppingListRepository,
            CocktailShoppingListRepository cocktailShoppingListRepository,
            CocktailService cocktailService) {
        this.shoppingListRepository = shoppingListRepository;
        this.cocktailShoppingListRepository = cocktailShoppingListRepository;
        this.cocktailService = cocktailService;
    }

    public ShoppingListResource createShoppingList(String name) {
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        shoppingListEntity.setId(UUID.randomUUID());
        shoppingListEntity.setName(name);
        ShoppingListEntity createdShoppingList = shoppingListRepository.save(shoppingListEntity);

        return new ShoppingListResource(createdShoppingList.getId(), createdShoppingList.getName());
    }

    public ShoppingListResource addCocktails(String shoppingListId, List<CocktailResource> cocktails) {
        for (CocktailResource cocktail : cocktails) {
            CocktailShoppingListEntity entity = new CocktailShoppingListEntity();
            entity.setCocktailId(cocktail.getCocktailId());
            entity.setShoppingListId(UUID.fromString(shoppingListId));
            cocktailShoppingListRepository.save(entity);
        }

        return this.getShoppingList(shoppingListId);
    }

    private void addIngredientsFromCocktail(ShoppingListResource shoppingList, CocktailResource cocktail) {
        if (!cocktail.getIngredients().isEmpty()) {
            shoppingList.addIngredients(cocktail.getIngredients());
        }
    }

    public ShoppingListResource getShoppingList(String shoppingListId) {
        ShoppingListEntity shoppingListEntity = this.shoppingListRepository.findById(UUID.fromString(shoppingListId));

        ShoppingListResource shoppingListResource = new ShoppingListResource(shoppingListEntity.getId(), shoppingListEntity.getName());
        shoppingListResource.addIngredients(
                this.cocktailShoppingListRepository.findByShoppingListId(shoppingListResource.getShoppingListId())
                        .stream()
                        .flatMap(e -> cocktailService.getCocktail(e.getCocktailId()).getIngredients().stream())
                        .collect(Collectors.toList())
        );

        return shoppingListResource;
    }

    public List<ShoppingListResource> getShoppingLists() {
        List<ShoppingListResource> shoppingLists = new ArrayList<>();
        List<ShoppingListEntity> shoppingListEntities = this.shoppingListRepository.findAll();

        for (ShoppingListEntity shoppingListEntity: shoppingListEntities) {
            ShoppingListResource shoppingListResource = new ShoppingListResource(shoppingListEntity.getId(), shoppingListEntity.getName());
            shoppingListResource.addIngredients(
                    this.cocktailShoppingListRepository.findByShoppingListId(shoppingListResource.getShoppingListId())
                    .stream()
                    .flatMap(e -> cocktailService.getCocktail(e.getCocktailId()).getIngredients().stream())
                    .collect(Collectors.toList())
            );

            shoppingLists.add(shoppingListResource);
        }

        return shoppingLists;
    }
}

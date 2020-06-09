package com.ezgroceries.shoppinglist.cocktails.service;

import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBClient;
import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBResponse;
import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBResponse.DrinkResource;
import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    private CocktailDBClient cocktailDBClient;

    public CocktailService(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    public CocktailResource getCocktail(UUID cocktailId) {
        return new CocktailResource(cocktailId
                , "Margerita",
                "Cocktail glass",
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt"));
    }

    public List<CocktailResource> getCocktails(String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);

        return mapDrinkToCocktailResource(cocktailDBResponse.getDrinks());
    }

    private List<CocktailResource> mapDrinkToCocktailResource(List<DrinkResource> drinks) {
        List<CocktailResource> cocktails = new ArrayList<>();
        for (DrinkResource drink: drinks) {
            cocktails.add(new CocktailResource(
                    UUID.randomUUID(),
                    drink.getStrDrink(),
                    drink.getStrGlass(),
                    drink.getStrInstructions(),
                    drink.getStrDrinkThumb(),
                    drink.getIngredients()
            ));
        }

        return cocktails;
    }
}

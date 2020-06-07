package com.ezgroceries.shoppinglist.shoppinglists.service;

import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import com.ezgroceries.shoppinglist.shoppinglists.model.ShoppingListResource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    public ShoppingListResource createShoppingList(String name) {
        return new ShoppingListResource(UUID.randomUUID(), name);
    }

    public ShoppingListResource addCocktails(String shoppingListId, List<CocktailResource> cocktails) {
        ShoppingListResource shoppingList = this.getShoppingList(shoppingListId);

        for (CocktailResource cocktail: cocktails ) {
            this.addIngredientsFromCocktail(shoppingList, cocktail);
        }

        return shoppingList;
    }

    private void addIngredientsFromCocktail(ShoppingListResource shoppingList, CocktailResource cocktail) {
        if (!cocktail.getIngredients().isEmpty()) {
            shoppingList.addIngredients(cocktail.getIngredients());
        }
    }

    public ShoppingListResource getShoppingList(String shoppingListId) {
        ShoppingListResource shoppingListResource = new ShoppingListResource(UUID.fromString(shoppingListId), "Test");
        shoppingListResource.addIngredient("Tequila");
        shoppingListResource.addIngredient("Triple sec");
        shoppingListResource.addIngredient("Lime juice");
        shoppingListResource.addIngredient("Salt");
        shoppingListResource.addIngredient("Blue Curacao");

        return shoppingListResource;
    }

    public List<ShoppingListResource> getShoppingLists() {
        List<ShoppingListResource> shoppingLists = new ArrayList<>();
        shoppingLists.add(this.getShoppingList("e71c4e44-2097-4342-8781-c92833b6207d"));
        shoppingLists.add(this.getShoppingList("e71c4e44-2097-4342-8781-c92833b6207e"));


        return shoppingLists;
    }
}

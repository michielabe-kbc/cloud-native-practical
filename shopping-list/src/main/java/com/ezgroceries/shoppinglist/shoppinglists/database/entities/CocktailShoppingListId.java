package com.ezgroceries.shoppinglist.shoppinglists.database.entities;

import java.io.Serializable;
import java.util.UUID;

public class CocktailShoppingListId implements Serializable {

    private UUID cocktailId;

    private UUID shoppingListId;

    public CocktailShoppingListId() {}

    public CocktailShoppingListId(UUID cocktailId, UUID shoppingListId) {
        this.cocktailId = cocktailId;
        this.shoppingListId = shoppingListId;
    }
}

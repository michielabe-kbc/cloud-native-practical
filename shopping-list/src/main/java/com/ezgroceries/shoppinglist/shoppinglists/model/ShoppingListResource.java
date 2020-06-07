package com.ezgroceries.shoppinglist.shoppinglists.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingListResource {

    private UUID shoppingListId;
    private String name;
    private List<String> ingredients = new ArrayList<String>();

    public ShoppingListResource(UUID shoppingListId, String name) {
        setShoppingListId(shoppingListId);
        setName(name);
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void addIngredients(List<String> ingredients) {
        if (!ingredients.isEmpty()) {
            this.ingredients.addAll(ingredients);
        }
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
}

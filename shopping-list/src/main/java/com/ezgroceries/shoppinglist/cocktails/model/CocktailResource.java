package com.ezgroceries.shoppinglist.cocktails.model;

import java.util.List;
import java.util.UUID;

public class CocktailResource {

    private UUID cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private List<String> ingredients;

    public CocktailResource(UUID cocktailId, String name, String glass, String instructions, String image, List<String> ingredients) {
        setCocktailId(cocktailId);
        setName(name);
        setGlass(glass);
        setInstructions(instructions);
        setImage(image);
        setIngredients(ingredients);
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}

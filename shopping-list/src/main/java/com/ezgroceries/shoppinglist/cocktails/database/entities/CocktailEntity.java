package com.ezgroceries.shoppinglist.cocktails.database.entities;

import com.ezgroceries.shoppinglist.utils.StringSetConverter;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {
    @Id
    @Column(name="ID")
    private UUID id;

    @Column(name="ID_DRINK")
    private String idDrink;

    @Column(name="NAME")
    private String name;

    @Column(name="GLASS")
    private String glass;

    @Column(name="INSTRUCTIONS")
    private String instructions;

    @Column(name = "IMAGE_LINK")
    private String imageLink;


    @Convert(converter = StringSetConverter.class)
    private List<String> ingredients;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

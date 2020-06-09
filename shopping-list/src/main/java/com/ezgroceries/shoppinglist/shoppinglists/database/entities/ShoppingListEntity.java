package com.ezgroceries.shoppinglist.shoppinglists.database.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    @Id
    @Column(name="ID")
    private UUID id;

    @Column(name="NAME")
    private String name;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

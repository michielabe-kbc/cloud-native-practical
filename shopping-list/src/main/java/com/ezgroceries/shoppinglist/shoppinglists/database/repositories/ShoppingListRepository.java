package com.ezgroceries.shoppinglist.shoppinglists.database.repositories;

import com.ezgroceries.shoppinglist.shoppinglists.database.entities.ShoppingListEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.Repository;

public interface ShoppingListRepository extends Repository<ShoppingListEntity, UUID> {

    public ShoppingListEntity findById(UUID id);

    ShoppingListEntity save(ShoppingListEntity newCocktailEntity);

    public List<ShoppingListEntity> findAll();
}

package com.ezgroceries.shoppinglist.shoppinglists.database.repositories;

import com.ezgroceries.shoppinglist.shoppinglists.database.entities.CocktailShoppingListEntity;
import com.ezgroceries.shoppinglist.shoppinglists.database.entities.CocktailShoppingListId;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.Repository;

public interface CocktailShoppingListRepository extends Repository<CocktailShoppingListEntity, CocktailShoppingListId> {

    public List<CocktailShoppingListEntity> findByShoppingListId(UUID shoppingListId);

    CocktailShoppingListEntity save(CocktailShoppingListEntity newCocktailShoppingListEntity);

}

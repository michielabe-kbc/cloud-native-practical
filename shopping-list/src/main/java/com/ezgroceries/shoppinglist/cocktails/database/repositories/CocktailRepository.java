package com.ezgroceries.shoppinglist.cocktails.database.repositories;

import com.ezgroceries.shoppinglist.cocktails.database.entities.CocktailEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.Repository;

public interface CocktailRepository extends Repository<CocktailEntity, UUID> {

    public CocktailEntity findById(UUID id);

    public List<CocktailEntity> findByIdDrinkIn(List<String> idDrinks);

    CocktailEntity save(CocktailEntity newCocktailEntity);

    List<CocktailEntity> findByNameContainingIgnoreCase(String search);
}

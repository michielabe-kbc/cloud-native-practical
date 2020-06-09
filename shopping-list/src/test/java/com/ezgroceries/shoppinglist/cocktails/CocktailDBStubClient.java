package com.ezgroceries.shoppinglist.cocktails;

import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBClient;
import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBResponse;
import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBResponse.DrinkResource;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Profile("stub")
public class CocktailDBStubClient implements CocktailDBClient {

    @GetMapping(value = "search.php")
    public CocktailDBResponse searchCocktails(@RequestParam("s") String search){
        CocktailDBResponse response = new CocktailDBResponse();

        List<DrinkResource> drinks = new ArrayList<>();

        CocktailDBResponse.DrinkResource drink = new CocktailDBResponse.DrinkResource();
        drink.setStrDrink("Margerita");
        drink.setStrGlass("Cocktail glass");
        drink.setStrInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it.");
        drink.setStrDrinkThumb("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        drink.setStrIngredient1("Tequila");
        drink.setStrIngredient1("Triple sec");
        drink.setStrIngredient1("Lime juice");
        drink.setStrIngredient1("Salt");

        drinks.add(drink);

        response.setDrinks(drinks);

        return response;
    }
}

package com.ezgroceries.shoppinglist.shoppinglists.controller;

import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import com.ezgroceries.shoppinglist.cocktails.service.CocktailService;
import com.ezgroceries.shoppinglist.shoppinglists.model.ShoppingListResource;
import com.ezgroceries.shoppinglist.shoppinglists.service.ShoppingListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping(produces = "application/json")
@EnableSwagger2
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CocktailService cocktailService;

    @GetMapping("/shopping-lists")
    public List<ShoppingListResource> getShoppingLists() {
        return this.shoppingListService.getShoppingLists();
    }

    @PostMapping("/shopping-lists")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListResource post(@RequestBody ShoppingListResource shoppingListResource) {
        return this.shoppingListService.createShoppingList(shoppingListResource.getName());
    }

    @GetMapping("/shopping-lists/{shoppingListId}")
    public ShoppingListResource getShoppingList(@PathVariable String shoppingListId) {
        return this.shoppingListService.getShoppingList(shoppingListId);
    }

    @PostMapping("/shopping-lists/{shoppingListId}/cocktails")
    public List<CocktailResource> addCocktails(@PathVariable String shoppingListId, @RequestBody List<CocktailResource> cocktails) {
        // get cocktails with ingredients
        List<CocktailResource> cocktailsWithIngredients = new ArrayList<>();
        for (CocktailResource cocktail: cocktails) {
            cocktailsWithIngredients.add(this.cocktailService.getCocktail(cocktail.getCocktailId()));
        }

        this.shoppingListService.addCocktails(shoppingListId, cocktailsWithIngredients);

        return cocktailsWithIngredients;
    }
}

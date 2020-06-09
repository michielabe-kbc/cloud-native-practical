package com.ezgroceries.shoppinglist.cocktails.controller;

import com.ezgroceries.shoppinglist.cocktails.model.CocktailResource;
import com.ezgroceries.shoppinglist.cocktails.service.CocktailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<CocktailResource> get(@RequestParam String search) {
        return this.cocktailService.getCocktails(search);
    }
}

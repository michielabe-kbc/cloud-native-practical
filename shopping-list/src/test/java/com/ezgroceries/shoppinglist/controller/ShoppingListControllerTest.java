package com.ezgroceries.shoppinglist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ComponentScan("com.ezgroceries.shoppinglist")
public class ShoppingListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getShoppingListTest() throws Exception {
        this.mockMvc.perform(get("/shopping-lists/eb18bb7c-61f3-4c9f-981c-55b1b8ee8915")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shoppingListId").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.ingredients").exists())
                .andExpect(jsonPath("$.ingredients").isArray())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void getAllShoppingListsTest() throws Exception {
        this.mockMvc.perform(get("/shopping-lists")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].shoppingListId").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].ingredients").exists())
                .andExpect(jsonPath("$[0].ingredients").isArray())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void createNewShoppingListTest() throws Exception {
        this.mockMvc.perform(post("/shopping-lists")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Stephanie's birthday\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.shoppingListId").exists())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void addCocktailToShoppingListTest() throws Exception {
        this.mockMvc.perform(post("/shopping-lists/97c8e5bd-5353-426e-b57b-69eb2260ace3/cocktails")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[\n"
                        + "  {\n"
                        + "    \"cocktailId\": \"23b3d85a-3928-41c0-a533-6538a71e17c4\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"cocktailId\": \"d615ec78-fe93-467b-8d26-5d26d8eab073\"\n"
                        + "  }\n"
                        + "]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].cocktailId").exists())
                .andExpect(content().contentType("application/json"));
    }
}

package com.ezgroceries.shoppinglist.shoppinglists.controller;

import com.ezgroceries.shoppinglist.shoppinglists.model.ShoppingListResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("stub")
@AutoConfigureMockMvc
@ComponentScan("com.ezgroceries.shoppinglist")
public class ShoppingListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getShoppingListTest() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/shopping-lists")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Stephanie's birthday\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.shoppingListId").exists())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        ShoppingListResource shoppingListResource = objectMapper.readValue(contentAsString, ShoppingListResource.class);

        this.mockMvc.perform(get("/shopping-lists/" + shoppingListResource.getShoppingListId().toString())
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
        MvcResult result = this.mockMvc.perform(post("/shopping-lists")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Stephanie's birthday\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.shoppingListId").exists())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        ShoppingListResource shoppingListResource = objectMapper.readValue(contentAsString, ShoppingListResource.class);
        String shoppinglistId = shoppingListResource.getShoppingListId().toString();

        this.mockMvc.perform(post("/shopping-lists/" + shoppinglistId + "/cocktails")
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

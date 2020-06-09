package com.ezgroceries.shoppinglist.cocktails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ezgroceries.shoppinglist.cocktails.database.CocktailDBClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("stub")
@AutoConfigureMockMvc
@ComponentScan("com.ezgroceries.shoppinglist")
public class CocktailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCocktailsTest() throws Exception {
        this.mockMvc.perform(get("/cocktails?search=russian")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].cocktailId").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].name").value("Margerita"))
                .andExpect(jsonPath("$[0].glass").exists())
                .andExpect(jsonPath("$[0].ingredients").exists())
                .andExpect(jsonPath("$[0].ingredients").isArray())
                .andExpect(content().contentType("application/json"));
    }
}

package com.bootcamp.testing.integration;

import ch.qos.logback.core.net.ObjectWriter;
import com.bootcamp.testing.dto.request.RecipeDTO;
import com.bootcamp.testing.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class RecipeControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1()  throws Exception{
        // Arrange
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setName("Burrito");
        recipeDTO.setDescription("Muy rico");
        recipeDTO.setIngredients(new ArrayList<>());

        RecipeDTO recipeDTO2 = new RecipeDTO();
        recipeDTO2.setName("Taco");
        recipeDTO2.setDescription("Rico");
        recipeDTO2.setIngredients(new ArrayList<>());

        String recipeJson = new ObjectMapper().writeValueAsString(recipeDTO);
        String payload = new ObjectMapper().writeValueAsString(recipeDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is2xxSuccessful();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(recipeJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content().contentType(MediaType.APPLICATION_JSON);
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/recipes/recipe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }
}

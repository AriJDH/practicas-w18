package com.bootcamp.testing.integration;

import com.bootcamp.testing.dto.request.RecipeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
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

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationRecipe {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration test createRecipe endpoint")
    void integrationCreateRecipe() throws Exception
    {
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        // Arrange
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setName("burri");
        recipeDTO.setDescription("aaaaaa");
        recipeDTO.setIngredients(new ArrayList<>());

        String recipeJson = objectWriter.writeValueAsString(recipeDTO);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(recipeJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        // Request

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.post("/recipes/recipe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipeJson);
        // Act and Assert
        mockMvc.perform(requestPayload)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}

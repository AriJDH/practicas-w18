package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.RecipeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class RecipeRepositoryTest {
    RecipeRepository repository;

    @BeforeEach
    void setup(){
        repository = new RecipeRepository();
    }

    @Test
    @DisplayName("Camino FELIZ Encontrando lista")
    void test1(){
        // Arrange
        int expectQuantity = 3;
        // Act
        List<Recipe> result = repository.getRecipes();
        // Assert TRAER SIEMPRE DE JUPITER
        Assertions.assertEquals(expectQuantity, result.size());
    }

    @Test
    @DisplayName("Camino FELIZ comparando listas")
    void test2(){
        // Arrange
        Recipe recipe = new Recipe();
        recipe.setName("demo");
        recipe.setDescription("demo description");
        recipe.setIngredients(new ArrayList<>());
        // Act
        Recipe result = repository.createRecipe(recipe);
        // Assert TRAER SIEMPRE DE JUPITER
        Assertions.assertEquals(recipe, result);
    }

}

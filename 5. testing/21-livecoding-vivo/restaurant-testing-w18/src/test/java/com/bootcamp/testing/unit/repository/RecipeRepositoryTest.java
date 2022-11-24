package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.RecipeRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepositoryTest {

    RecipeRepository recipeRepository;

    @BeforeEach
    void setup() {
        recipeRepository = new RecipeRepository();
    }

    @Test
    @DisplayName("Encontramos una ingrediente que existe")
    void test1() {
        // Arrange
        int recipeQuantityExpected = 3;
        // Act
        List<Recipe> result = recipeRepository.getRecipes();
        // Assert
        Assertions.assertEquals(recipeQuantityExpected, result.size());
    }

    @Test
    @DisplayName("Agrego un recipe y me devuelve el mismo")
    void test2() {
        // Arrange
        Recipe recipe = new Recipe();
        recipe.setName("demo");
        recipe.setDescription("lorem ipsum");
        recipe.setIngredients(new ArrayList<>());
        // Act
        Recipe result = recipeRepository.createRecipe(recipe);
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(recipe, result),
                () -> Assertions.assertEquals("demo", result.getName()),
                () -> Assertions.assertEquals(4, recipeRepository.getRecipes().size())
        );
    }
}

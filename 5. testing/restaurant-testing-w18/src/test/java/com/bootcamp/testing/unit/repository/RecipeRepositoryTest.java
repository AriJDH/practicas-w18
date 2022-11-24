package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RecipeRepositoryTest {
    RecipeRepository repository;

    @BeforeEach
    void setup()
    {
        repository = new RecipeRepository();
    }

    @Test
    @DisplayName("CASO FELIZ :D getRecipies method")
    void getRecipeTest()
    {
        // Arrange
        int expectQuantity = 3;
        // Act
        List<Recipe> result = repository.getRecipes();
        // Assert
        Assertions.assertEquals(expectQuantity, result.size());
    }

    @Test
    @DisplayName("CASO FELIZ :D createRecipe method")
    void createRecipeTest()
    {
        Recipe recipe = new Recipe();
        recipe.setName("demo");
        recipe.setDescription("aaaaaa");
        recipe.setIngredients(new ArrayList<>());

        Recipe result = repository.createRecipe(recipe);
        Assertions.assertEquals(recipe, result);
        /*
        Assertions.assertAll(
            () -> Assertions.assertEquals(recipe, result),
            () -> Assertions.assertEquals(5, repository.getRecipes().size)
        );
         */
    }
}

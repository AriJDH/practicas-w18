package com.bootcamp.testing.unit.service;

import com.bootcamp.testing.dto.response.DishResponseDTO;
import com.bootcamp.testing.exception.notfound.IngredientNotFoundException;
import com.bootcamp.testing.exception.notfound.RecipeNotFoundException;
import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import com.bootcamp.testing.repository.interfaces.IStorehouseRepository;
import com.bootcamp.testing.service.KitchenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bootcamp.testing.utils.IngredientFactory.*;
import static com.bootcamp.testing.utils.RecipeFactory.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class KitchenServiceTest {
    @Mock
    IRecipeRepository recipeRepository;
    @Mock
    IStorehouseRepository storehouseRepository;
    @InjectMocks
    KitchenService service;

    @Test
    @DisplayName("CAMINO FELIZ :D createDish method | calculate quality ")
    void createDishTest()
    {
        // Arrange
        String name = "Pizza";
        Double expectedQuality = 4D;

        // Mock
        Recipe recipe = getRecipe("pizza");
        Ingredient ingredient = getIngredientWithQuality("a", 4);

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);

        recipe.setIngredients(ingredientList);

        // Mockito
        Mockito.when(storehouseRepository.getIngredient(ingredient.getName())).thenReturn(Optional.of(ingredient));
        Mockito.when(recipeRepository.getRecipe(name)).thenReturn(Optional.of(recipe));

        // Act
        DishResponseDTO result = service.createDish(name);
        // Assert
        Assertions.assertEquals(expectedQuality, result.getQuality());

    }

    @Test
    @DisplayName("CAMINO TRISTE D: createDish method | recipe not found")
    void NoCreateDishTest1()
    {
        String name = "aaa";
        Mockito.when(recipeRepository.getRecipe(name)).thenReturn(Optional.empty());
        Assertions.assertThrows(RecipeNotFoundException.class, () -> service.createDish(name));
    }

    @Test
    @DisplayName("CAMINO TRISTE D: createDish method | ingredient not found")
    void NoCreateDishTest2()
    {
        String nameRecipe = "aaa";
        String nameIngredient = "bbb";

        Recipe recipe = getRecipe(nameRecipe);

        Mockito.when(recipeRepository.getRecipe(nameRecipe)).thenReturn(Optional.of(recipe));
        //Mockito.when(storehouseRepository.getIngredient(nameIngredient)).thenReturn();

        Assertions.assertThrows(IngredientNotFoundException.class, () -> service.createDish(nameRecipe));
    }
}

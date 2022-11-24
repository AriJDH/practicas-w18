package com.bootcamp.testing.unit.service;

import com.bootcamp.testing.dto.response.DishResponseDTO;
import com.bootcamp.testing.exception.notfound.RecipeNotFoundException;
import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import com.bootcamp.testing.repository.interfaces.IStorehouseRepository;
import com.bootcamp.testing.service.KitchenService;
import com.bootcamp.testing.utils.IngredientFactory;
import com.bootcamp.testing.utils.RecipeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class KitchenServiceTest {

    @Mock
    IRecipeRepository recipeRepository;
    @Mock
    IStorehouseRepository storehouseRepository;

    @InjectMocks
    KitchenService kitchenService;

    @Test
    @DisplayName("Agrego un recipe con un nombre y me devuelve el mismo")
    void test1() {
        // Arrange
        String dishName = "pizza";
        Double expectedQuality = 3.0; // Tiene que estar hardcoded!

        // Mocks
        Recipe recipe = RecipeFactory.getRecipeWithQuality(dishName);
//        Ingredient ingredient1 = IngredientFactory.getIngredientWithQuality(4);
//        Ingredient ingredient2 = IngredientFactory.getIngredientWithQuality(3);
        // Mock
        Mockito.when(recipeRepository.getRecipe(dishName))
                .thenReturn(Optional.of(recipe));
        for (Ingredient ingredient : recipe.getIngredients()) {
            Mockito.when(storehouseRepository.getIngredient(ingredient.getName()))
                    .thenReturn(Optional.of(ingredient));
        }
//        Mockito.when(storehouseRepository.getIngredient(ingredient1.getName()))
//                .thenReturn(Optional.of(ingredient1));
//        Mockito.when(storehouseRepository.getIngredient(ingredient2.getName()))
//                .thenReturn(Optional.of(ingredient2));

        // Act
        DishResponseDTO result = kitchenService.createDish(dishName);

        // Assert
        Assertions.assertEquals(expectedQuality, result.getQuality());
    }

    @Test
    @DisplayName("Camino triste - tira exception ")
    void test2() {
        // Arrange
        String dishName = "pizza";
        //Mock
        Mockito.when(recipeRepository.getRecipe(dishName)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(RecipeNotFoundException.class, () -> kitchenService.createDish(dishName));
    }

}

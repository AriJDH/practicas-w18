package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.repository.StorehouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StorehouseRepositoryTest
{
    StorehouseRepository repository = new StorehouseRepository();

    @Test
    @DisplayName("Caso FELIZ :D getIngredients method")
    void getIngredientsTest()
    {
        // Arrange
        String nameIngredient = "manzana";
        // Act
        Optional<Ingredient> result = repository.getIngredient(nameIngredient);
        // Assert
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Caso TRISTE D: getIngredients method")
    void noGetIngredientsTest()
    {
        String nameIngredient = "aaaaaaaa";
        Optional<Ingredient> result = repository.getIngredient(nameIngredient);
        Assertions.assertTrue(result.isEmpty());
    }
}

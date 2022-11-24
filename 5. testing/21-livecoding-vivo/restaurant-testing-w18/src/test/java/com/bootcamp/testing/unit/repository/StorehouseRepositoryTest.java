package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.repository.StorehouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class StorehouseRepositoryTest {

    StorehouseRepository storehouseRepository = new StorehouseRepository();

    @Test
    @DisplayName("Encontramos una ingrediente que existe")
    void test1() {
        // Arrange
        String ingredientName = "manzana";
        // Act
        Optional<Ingredient> result = storehouseRepository.getIngredient(ingredientName);
        // Assert
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("No encontramos una ingrediente que no existe")
    void test2() {
        // Arrange
        String ingredientName = "not found";
        // Act
        Optional<Ingredient> result = storehouseRepository.getIngredient(ingredientName);
        // Assert
        Assertions.assertTrue(result.isEmpty());
    }


}

package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.repository.StorehouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class StorehouseRepositoryTest {

    // ---------------TEST UNITARIO-----------------
    StorehouseRepository storehouseRepository = new StorehouseRepository();


    @Test
    @DisplayName("Camino FELIZ Encontrando ingrediente")
    void test1(){
        // Arrange
        String nameIngredient = "tomato";
        // Act
        Optional<Ingredient> result = storehouseRepository.getIngredient(nameIngredient);
        // Assert TRAER SIEMPRE DE JUPITER
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Camino TRISTE No encontramos un ingrediente")
    void test2(){
        // Arrange
        String nameIngredient = "not found";
        // Act
        Optional<Ingredient> result = storehouseRepository.getIngredient(nameIngredient);
        // Assert TRAER SIEMPRE DE JUPITER
        Assertions.assertTrue(result.isEmpty());
    }

    //------------ EXCEPCIONES SOLO EN EL SERVICIO, GOT IT -------------------

}

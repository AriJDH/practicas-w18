package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Autowired
    private CharacterRepositoryImpl characterRepositoryImpl;

    @BeforeEach
    public void setUp() {
        characterRepositoryImpl = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContains() {

        //Arrange
        String nombrePersonaje = "Darth";

        //Act
        List<CharacterDTO> characterDTOs = characterRepositoryImpl.findAllByNameContains(nombrePersonaje);

        //Assert
        assertTrue(characterDTOs.get(0).getName().contains(nombrePersonaje), "El nombre del personaje debe contener Luke");
    }

}
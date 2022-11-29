package com.spring.starwars.repository;

import com.spring.starwars.dto.CharacterDtoRes;
import com.spring.starwars.entity.Personaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {
    @Autowired
    ICharacterRepository characterRepository;

    @Test
    @DisplayName("Happy ending :D")
    void findCharactersOk() {

        // Arrange
        List<Personaje> expected = new ArrayList<>();
        expected.add(new Personaje("Luke Skywalker",  172,
                                            77,
                                            "blond",
                                           "fair",
                                            "blue",
                                            "19BBY",
                                           "male",
                                            "Tatooine",
                                             "Human"));

        // Act
        List<Personaje> result = characterRepository.findCharacters("Luke");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Sad ending :(")
    void findCharactersSad() {

        // Arrange
        List<Personaje> expected = new ArrayList<>();

        // Act
        List<Personaje> result = characterRepository.findCharacters("Axel");

        // Assert
        Assertions.assertEquals(expected, result);
    }
}

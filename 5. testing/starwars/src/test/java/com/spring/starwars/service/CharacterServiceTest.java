package com.spring.starwars.service;


import com.spring.starwars.dto.CharacterDtoRes;
import com.spring.starwars.entity.Personaje;
import com.spring.starwars.repository.ICharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {
    @Mock
    ICharacterRepository characterRepository;
    @InjectMocks
    CharacterService characterService;

    @Test
    @DisplayName("Test")
    void test1() {
        // Arrange
        String name = "Luke";

        Personaje luke = new Personaje("Luke Skywalker",  172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human");

        List<Personaje> lukes = Arrays.asList(luke);
        List<CharacterDtoRes> expectedCharacters = lukes.stream()
                .map(c -> new CharacterDtoRes(c.getName(),
                        c.getHeight(),
                        c.getMass(),
                        c.getGender(),
                        c.getHomeworld(),
                        c.getSpecies()))
                .collect(Collectors.toList());
        Mockito.when(characterRepository.findCharacters(name)).thenReturn(lukes);

        // Act
        List<CharacterDtoRes> result = characterService.findCharacters(name);

        // Assert
        Assertions.assertEquals(expectedCharacters, result);

    }

}

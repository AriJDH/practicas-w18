package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {
        // arrange
        String query = "Darth";
//        List<CharacterDTO> expectedCharacterDTOList = new ArrayList<>();
//        expectedCharacterDTOList.add(new CharacterDTO()); // Darth Maul
//        expectedCharacterDTOList.add(new CharacterDTO()); // Darth Vader

//        mock = listaaaaa
//         Es necesario probar con una comparacion entre un expected y en result??

        // act
        findController.find(query);
        // assert
//        verify(findService, atLeastOnce()).find(query);
    }
}
package com.mercadolibre.starwars;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension. class)
public class FindControllerTest {
    @Mock
    private FindService findService;
    @InjectMocks
    private FindController findController;

    private CharacterDTO luke = new CharacterDTO("Luke", "brown", "white", "blue"
            , "1990", "male","earth","human",180,80);

    @Test
    public void find(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(luke);
        when(findService.find("Luke")).thenReturn(characters);

        List<CharacterDTO> controllerResponse = findController.find("Luke");

        Assertions.assertTrue(controllerResponse.contains(luke));
    }
}

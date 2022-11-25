package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    public void find() {

        //Arrange
        String nombrePersonaje = "3PO";

        List<CharacterDTO> characterDTOs = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(nombrePersonaje);
        characterDTOs.add(characterDTO);

        when(characterRepository.findAllByNameContains(any())).thenReturn(characterDTOs);

        //Act
        List<CharacterDTO> characterConsultadosDTOs = findService.find(nombrePersonaje);

        //Assert
        assertTrue(characterConsultadosDTOs.get(0).getName().contains(nombrePersonaje),
                "El nombre del personaje debe contener " + nombrePersonaje);

        assertEquals(characterConsultadosDTOs.size(), 1, "El tamanio de la lista debe ser 1");
    }
}

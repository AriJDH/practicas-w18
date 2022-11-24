package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;
    private CharacterDTO luke = new CharacterDTO("Luke", "brown", "white", "blue"
            , "1990", "male","earth","human",180,80);

    @Test
    public void find(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(luke);
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(characters);

        List<CharacterDTO> response = findService.find("Luke");
        System.out.println(response.size());
        Assertions.assertTrue(response.contains(luke));
    }
}

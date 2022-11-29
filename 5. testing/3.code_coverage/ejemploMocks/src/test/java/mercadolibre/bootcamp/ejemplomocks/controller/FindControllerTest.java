package mercadolibre.bootcamp.ejemplomocks.controller;

import mercadolibre.bootcamp.ejemplomocks.dto.CharacterDTO;
import mercadolibre.bootcamp.ejemplomocks.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService mockFindService;
    @InjectMocks
    private FindController findController;

    @Test
    void shouldFindCharatersByName(){
        //arrange
        String query = "Sofia";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Sofia");
        characterDTO1.setHair_color("red");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Pablo");
        characterDTO2.setHair_color("brown");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1,characterDTO2);
        when(mockFindService.find(query)).thenReturn(characterDTOList);

        //act
        List<CharacterDTO> result = findController.find(query);

        //assert
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(),"Sofia");
        verify(mockFindService, atLeastOnce()).find(query);
    }
}

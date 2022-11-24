package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension. class)
public class CalculateRestControllerTest {
    @Mock
    private CalculateService calculateService;
    @InjectMocks
    private CalculateRestController calculateRestController;
    @Autowired
    private MockMvc mockMvc;
    private RoomDTO habitacion = new RoomDTO("Habitacion", 100, 100);
    private RoomDTO cocina = new RoomDTO("Cocina", 125, 125);
    private RoomDTO living = new RoomDTO("Living", 150, 150);
    private RoomDTO[] rooms = {habitacion, cocina, living};
    private HouseDTO casa = new HouseDTO("Casa", "Avenida siempre viva 123", Arrays.stream(rooms).collect(Collectors.toList()));

    private HouseResponseDTO houseResponseDTO = new HouseResponseDTO(100*100+125*125+150*150, 800*(100*100+125*125+150*150),living);
    @Test
    public void calculate() {
        when(calculateService.calculate(casa)).thenReturn(houseResponseDTO);
        HouseResponseDTO res =  calculateRestController.calculate(casa);
        Assertions.assertEquals(res, houseResponseDTO);
    }

    private String getRoom(String name, int width, int length) {
        return "{\"name\": \""+name+"\", \"width\": "+width+", \"length\": "+length+"}";
    }

}

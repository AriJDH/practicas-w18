package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    @DisplayName("Mock - calculateService.calculate")
    void test1() {

        //Arrange
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Cocina", 10, 10));
        rooms.add(new RoomDTO("Baño", 5, 5));
        rooms.add(new RoomDTO("Comedor", 20, 10));

        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setSquareFeet(10 * 10 + 5 * 5 + 20 * 10);
        expected.setPrice((10 * 10 + 5 * 5 + 20 * 10) * 800);
        expected.setRooms(rooms);
        expected.setBiggest(rooms.get(2));

        //Mock
        when(calculateService.calculate(house)).thenReturn(expected);

        //Act
        HouseResponseDTO result = calculateService.calculate(house);

        //Assert
        assertAll(
                () -> assertEquals(result.getPrice(), 260000),
                () -> assertEquals(result.getSquareFeet(), 325),
                () -> assertEquals(result.getRooms(), rooms));

    }

}

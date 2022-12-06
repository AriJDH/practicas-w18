package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Calculate - SquareFeet")
    public void test1() {

        //Arrange
        Integer expectedSquareFeet = 75;
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Cocina", 5, 5));
        rooms.add(new RoomDTO("Baño", 5, 5));
        rooms.add(new RoomDTO("Comedor", 5, 5));

        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        //Act
        HouseResponseDTO result = calculateService.calculate(house);

        assertEquals(result.getSquareFeet(), expectedSquareFeet);
    }

    @Test
    @DisplayName("Calculate - BiggestRoom")
    public void test2() {

        //Arrange
        RoomDTO expectedRoom = new RoomDTO("Comedor", 45, 5);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Cocina", 4, 5));
        rooms.add(new RoomDTO("Baño", 2, 3));
        rooms.add(new RoomDTO("Comedor", 45, 5));

        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        assertEquals(houseResponseDTO.getBiggest().getName(), expectedRoom.getName());
    }

    @Test
    @DisplayName("Calculate - Price")
    public void calculateSquareFeet() {

        //Arrange
        Integer expectedPrice = 4983200;
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Cocina", 44, 54));
        rooms.add(new RoomDTO("Baño", 26, 53));
        rooms.add(new RoomDTO("Comedor", 45, 55));

        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        assertEquals(houseResponseDTO.getPrice(), expectedPrice);
    }

}

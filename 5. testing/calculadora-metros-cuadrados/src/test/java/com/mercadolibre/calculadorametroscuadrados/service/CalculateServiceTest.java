package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    @Test
    public void calculate() {

        //Arrange
        HouseDTO houseDTO = new HouseResponseDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Habitacion 1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);
        rooms.add(roomDTO);
        houseDTO.setRooms(rooms);

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(houseResponseDTO.getPrice(), 80000, "El costo debe ser 80000");
    }
}
package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootTest
public class CalculateServiceTest {
    @Autowired
    private CalculateService calculateService;
    private RoomDTO habitacion = new RoomDTO("Habitacion", 100, 100);
    private RoomDTO cocina = new RoomDTO("Cocina", 125, 125);
    private RoomDTO living = new RoomDTO("Living", 150, 150);
    private RoomDTO[] rooms = {habitacion, cocina, living};
    private HouseDTO casa = new HouseDTO("Casa", "Avenida siempre viva 123", Arrays.stream(rooms).collect(Collectors.toList()));

    @Test
    public void calculatePrice(){
        int expectedPrice = (100*100+125*125+150*150)*800;

        HouseResponseDTO houseResponseDTO = calculateService.calculate(casa);

        Assertions.assertEquals(houseResponseDTO.getPrice(), expectedPrice);
    }

    @Test
    public void getBiggerRoom(){
        RoomDTO expectedRoom = living;

        HouseResponseDTO houseResponseDTO = calculateService.calculate(casa);

        Assertions.assertEquals(houseResponseDTO.getBiggest(), expectedRoom);
    }

    @Test
    public void calculateSquareFeet(){
        int expectedSquareFeet = 100*100+125*125+150*150;

        HouseResponseDTO houseResponseDTO = calculateService.calculate(casa);

        Assertions.assertEquals(houseResponseDTO.getSquareFeet(), expectedSquareFeet);
    }
}

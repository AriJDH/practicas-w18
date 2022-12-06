package com.mercadolibre.calculadorametroscuadrados.unit.dto;

import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RoomDTOTest {

    @Nested
    @DisplayName("Test - getSquareFeet")
    class getSquareFeet {

        @Test
        @DisplayName("Success - Length and Width != null")
        void test1() {

            //Arrange
            Integer expected = 300;
            RoomDTO room = new RoomDTO();
            room.setLength(30);
            room.setWidth(10);

            //Act
            Integer result = room.getSquareFeet();

            //Assert
            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Success - Length or Width null")
        void test2() {

            //Arrange
            Integer expected = 0;
            RoomDTO room = new RoomDTO();
            room.setLength(null);
            room.setWidth(10);

            //Act
            Integer result = room.getSquareFeet();

            //Assert
            Assertions.assertEquals(expected, result);
        }

    }

}

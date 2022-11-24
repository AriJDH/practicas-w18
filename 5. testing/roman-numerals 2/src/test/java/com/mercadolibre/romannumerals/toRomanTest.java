package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class toRomanTest {

    @Test
    void intToRomanOKTest(){
        //Arrange
        Integer input = 9;
        String expectedResponse = "IX";

        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(input);

        //Assert
        Assertions.assertEquals(result, expectedResponse);
    }

}

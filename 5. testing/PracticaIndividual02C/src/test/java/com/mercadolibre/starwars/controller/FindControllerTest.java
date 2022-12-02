package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void find() {

        //Arrange
        String nombrePersonaje = "Darth";

        //Act
        //Assert
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", nombrePersonaje))
                    .andDo(print())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
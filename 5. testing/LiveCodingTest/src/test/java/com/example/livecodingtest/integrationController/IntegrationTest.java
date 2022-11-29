package com.example.livecodingtest.integrationController;

import com.example.livecodingtest.dto.ErrorDto;
import com.example.livecodingtest.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void integracionGetTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    void integracionPostTest() throws Exception{
        UserDto userDto = new UserDto("Martin", "Marquez", 30);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String payloadDto = writer.writeValueAsString(userDto);

        MvcResult mvcResult = this.mockMvc.perform(post("/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(payloadDto, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void validacionFallidaTest() throws Exception{
        UserDto userDto = new UserDto("Martin", "Marquez", 123);
        ErrorDto errorDto = new ErrorDto("No puede tener mas de 99 anios.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadDto = writer.writeValueAsString(userDto);
        String error = writer.writeValueAsString(errorDto);

                MvcResult mvcResult = this.mockMvc.perform(post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                        .andDo(print())
                        .andReturn();

        Assertions.assertEquals(error, mvcResult.getResponse().getContentAsString());
    }
}

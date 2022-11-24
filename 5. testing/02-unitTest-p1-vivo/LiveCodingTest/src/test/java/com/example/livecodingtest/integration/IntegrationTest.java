package com.example.livecodingtest.integration;

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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void intTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void intPostTest() throws Exception {
        UserDto userDto = new UserDto("Maaaa", "Queeee", 30);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String payloadDto = objectWriter.writeValueAsString(userDto);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(payloadDto, response.getResponse().getContentAsString());
    }

    @Test
    void validacionFallidaTest() throws Exception {
        UserDto userDto = new UserDto("Maaaa", "Queeee", 3001);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadDto = objectWriter.writeValueAsString(userDto);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // HAY QUE VERIFICAR EL ERROR DTO DEVUELTO
    }
}

package com.meli.be_java_hisp_w18_g01.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserController {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Seguir a un usuario")
    public void follow() throws Exception {

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is(200);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.
                post("/users/{userId}/follow/{userIdToFollow}", 2, 1);
        // Act y Assert
        this.mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus);

    }
    @Test
    @DisplayName("Seguir a un usuario que no existe")
    public void followNonExistUser() throws Exception{
        // Arrange
        ResponseDTO errorDTO = new ResponseDTO(404,"El usuario 20 no existe.");
        String error = new ObjectMapper().writeValueAsString(errorDTO);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is(404);
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(error);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_JSON);
        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}",1,20);
        // Act y Assert
        this.mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("Dejar de seguir a un usuario")
    public void unfollow() throws Exception{
        ResultMatcher expectedStatusOk = MockMvcResultMatchers.status().is(200);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 3,2))
                .andDo(print())
                .andExpect(expectedStatusOk);
    }


    }




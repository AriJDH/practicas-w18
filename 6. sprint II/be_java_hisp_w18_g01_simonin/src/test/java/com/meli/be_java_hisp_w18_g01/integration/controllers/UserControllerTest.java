package com.meli.be_java_hisp_w18_g01.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T0011 - Consultando la cantidad de seguidores de un usuario")
    void getFollowersCount() throws Exception {

        //Arange
        Long id = 1L;
        UserFollowersCountDTO userExpect = new UserFollowersCountDTO(1L, "lucas", 1);
        String expect = new ObjectMapper().writeValueAsString(userExpect);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", id)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert

        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("T0012 - Usuario desea seguir a un vendedor")
    void followUserOk() throws Exception {

        //Arange
        Long idUser = 3L;
        Long idSeller = 1L;

        ResponseDTO responseExpect = new ResponseDTO(200, "operación exitosa");
        String expect = new ObjectMapper().writeValueAsString(responseExpect);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("T0012 - Usuario desea seguirse a si mismo")
    void followYourself() throws Exception {

        //Arange
        Long idUser = 1L;
        Long idSeller = 1L;

        ResponseDTO responseExpect = new ResponseDTO(400, "Un usuario no puede seguir a sí mismo.");
        String expect = new ObjectMapper().writeValueAsString(responseExpect);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("T0012 - Usuario desea seguir a un usuario que no es vendedor")
    void followUserNotSeller() throws Exception {

        //Arange
        Long idUser = 1L;
        Long idSeller = 3L;

        ResponseDTO responseExpect = new ResponseDTO(400, "No puede seguir al usuario " + idSeller + " porque no es un vendedor.");
        String expect = new ObjectMapper().writeValueAsString(responseExpect);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", idUser, idSeller)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("T0013 - Listar seguidos de un usuario")
    void getFollowedInfo() throws Exception {
        //Arrange
        Long idUser = 2L;
        List<UserDTO> followed = Arrays.asList(new UserDTO(1L, "lucas"));
        UserFollowedInfoDTO userExpect = new UserFollowedInfoDTO(idUser, "miguel", followed);

        String expect = new ObjectMapper().writeValueAsString(userExpect);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", idUser)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Asserte
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}
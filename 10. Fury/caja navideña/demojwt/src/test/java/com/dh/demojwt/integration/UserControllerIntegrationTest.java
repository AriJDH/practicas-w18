package com.dh.demojwt.integration;

import com.dh.demojwt.dto.request.UserRequestDTO;
import com.dh.demojwt.dto.response.UserResponseDTO;
import com.dh.demojwt.model.RolE;
import com.dh.demojwt.service.SessionServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static String token;

    /* Si no usan esto lo pueden borrar, es por si <SessionServiceImpl.getJWTToken> lo hacen static*/
    @BeforeAll
    static void setup (){

//        List<String> roles = new ArrayList<>();
//        roles.add(RolE.ADMIN.getText());
//        roles.add(RolE.BUYER.getText());
//        token = SessionServiceImpl.getJWTToken("marco", roles);
    }

    @BeforeEach
    void loadToken() throws Exception {
        UserRequestDTO user = new UserRequestDTO("marco", "calle falsa 123");
        String userPayload = new ObjectMapper().writer().writeValueAsString(user);

        MockHttpServletRequestBuilder request = post("/api/v1/sign-in")
          .contentType(MediaType.APPLICATION_JSON)
          .content(userPayload);

        String response = mockMvc.perform(request)
          .andReturn()
          .getResponse()
          .getContentAsString();

        UserResponseDTO userToken = new ObjectMapper().readValue(response, UserResponseDTO.class);
        token = userToken.getToken();
    }


    @Test
    @DisplayName("Demo buyer test")
    void demoBuyerTest () throws Exception {
        // Arrange
        String expectedString = "user with buyer: marco - [BUYER, ADMIN]";

        ResultMatcher expectedStatus  = status().isOk();
        ResultMatcher expectedContent = content().string(expectedString);

        MockHttpServletRequestBuilder request = get("/api/v1/users/buyer-1")
          .header("Authorization", token);

        // Act & Assert
        mockMvc.perform(request)
          .andDo(print())
          .andExpectAll(
            expectedStatus,
            expectedContent
          );
    }
}

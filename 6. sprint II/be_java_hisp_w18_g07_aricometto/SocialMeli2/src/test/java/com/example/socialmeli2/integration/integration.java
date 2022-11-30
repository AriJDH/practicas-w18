package com.example.socialmeli2.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class integration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Seguir a un usuario vendedor")
    void FollowSeller () throws Exception {
        //@GetMapping("/users/{userId}/follow/{userIdToFollow})

        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Act & Assert
        MockHttpServletRequestBuilder mvcResult = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

        mockMvc.perform(mvcResult)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }

    @Test
    @DisplayName("Seguir a un usuario que no es vendedor")
    void FollowNoSeller () throws Exception{

        Integer userId = 2;
        Integer userIdToFollow = 1;

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act & Assert
        MockHttpServletRequestBuilder mvcResult = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

        mockMvc
                .perform(mvcResult)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }

    @Test
    @DisplayName("Seguir a un usuario que no es existe")
    void FollowUserNoExistent() throws Exception{

        Integer userId = 1;
        Integer userIdToFollow = 9999;

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act & Assert
        MockHttpServletRequestBuilder mvcResult = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

        mockMvc
                .perform(mvcResult)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }
}

package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.response.UserBasicResponse;
import com.example.socialmeli2.dto.response.UserFollowedListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("T-0011 - Integration - User followed list")
    class getUsersFollowed {

        @Test
        void whenValidInput_thenReturns200() throws Exception {
            // Arrange
            Integer userId = 1;
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is2xxSuccessful();
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/users/{userId}/followed/list", userId);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus);
        }

        @Test
        void whenValidInput_thenReturnsDto() throws Exception {
            // Arrange
            Integer userId = 1;
            /* Expected */
            String userName = "Carlos";
            List<UserBasicResponse> userBasicResponseList = new ArrayList<>();
            userBasicResponseList.add(new UserBasicResponse(2,"Felipe"));
            UserFollowedListResponse expected = new UserFollowedListResponse(userId, userName,  userBasicResponseList);
            String expectedJsonString = objectMapper.writeValueAsString(expected);
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is2xxSuccessful();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedJsonString);
            ResultMatcher expectedContentType = MockMvcResultMatchers
                    .content().contentType(MediaType.APPLICATION_JSON);
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/users/{userId}/followed/list", userId);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);
        }
    }
}
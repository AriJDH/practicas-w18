package com.socialmeli.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ErrorDTO;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Nested
    @DisplayName("Integration US-0001")
    class T0001{
        @Test
        @DisplayName("Both users exist")
        void test1() throws Exception{

            // Arrange
            Integer seller_id = 20;
            Integer buyer_id = 2;

            // Matchers
            ResultMatcher expectedStatus = status().isOk();

            MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/follow/{userIdToFollow}", buyer_id, seller_id);

            // Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpect(expectedStatus);
        }

        @Test
        @DisplayName("Buyer not found")
        void test2() throws Exception{

            // Arrange
            Integer seller_id = 20;
            Integer buyer_id = 54;

            ErrorDTO errorDTO = new ErrorDTO("Buyer id 54 not found", 404);
            String errorJson = new ObjectMapper().writeValueAsString(errorDTO);

            // Matchers
            ResultMatcher expectedStatus = status().isNotFound();
            ResultMatcher expectedError = content().json(errorJson);
            ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

            MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/follow/{userIdToFollow}", buyer_id, seller_id);

            // Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedError, expectedContentType);
        }
        @Test
        @DisplayName("Seller not found")
        void test3() throws Exception{

            // Arrange
            Integer seller_id = 32;
            Integer buyer_id = 2;

            ErrorDTO errorDTO = new ErrorDTO("Seller id 32 not found", 404);
            String errorJson = new ObjectMapper().writeValueAsString(errorDTO);

            // Matchers
            ResultMatcher expectedStatus = status().isNotFound();
            ResultMatcher expectedError = content().json(errorJson);
            ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

            MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/follow/{userIdToFollow}", buyer_id, seller_id);

            // Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedError, expectedContentType);
        }
    }

    @Nested
    @DisplayName("Integration US-0007")
    class T0007{
        @Test
        @DisplayName("Buyer follows seller")
        void test3() throws Exception{

            // Arrange
            Integer seller_id = 60;
            Integer buyer_id = 3;

            // Matchers
            ResultMatcher expectedStatus = status().isOk();

            MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/unfollow/{userIdToFollow}", buyer_id, seller_id);

            // Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpect(expectedStatus);
        }

        @Test
        @DisplayName("Buyer doesn't follow seller")
        void test4() throws Exception{

            // Arrange
            Integer seller_id = 60;
            Integer buyer_id = 2;
            ErrorDTO errorDTO = new ErrorDTO("The buyer id 2 doesn't follow the seller id 60", 400);

            String errorJson = new ObjectMapper().writeValueAsString(errorDTO);
            // Matchers
            ResultMatcher expectedStatus = status().isBadRequest();
            ResultMatcher expectedError = content().json(errorJson);
            ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

            MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/unfollow/{userIdToFollow}", buyer_id, seller_id);

            // Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedError, expectedContentType);
        }
    }

    @Test
    @DisplayName("Integration US-0003")
    void test1() throws Exception{
        // Arrange
        Integer user_id = 60;
        String user_name = "seller6";

        SellerFollowersCountDTOResponse dtoResponse = new SellerFollowersCountDTOResponse();
        dtoResponse.setUser_id(user_id);
        dtoResponse.setUser_name(user_name);
        dtoResponse.setFollowers_count(2);

        String followersJson = new ObjectMapper().writeValueAsString(dtoResponse);
        // Matchers
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedResponse = content().json(followersJson);
        ResultMatcher expectedContentType =
                 content()
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = get("/users/{sellerId}/followers/count", user_id);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedResponse, expectedContentType);
    }





}

package com.example.socialmeli2.integration;

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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Nested
    @DisplayName("IT - POST followUserSeller")
    class followUserSeller {

        @Test
        @DisplayName("Success")
        void test1() throws Exception {

            //Arrange
            Integer userId = 1;
            Integer userIdToFollow = 2;

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus);
        }

        @Test
        @DisplayName("Not Success - User to follow is not a Seller")
        void test2() throws Exception {

            //Arrange
            Integer userId = 1;
            Integer userIdToFollow = 3;
            String responseBody = "{\"message\":\"El usuario con ID: " + userIdToFollow + " no es vendedor\",\"statusCode\":400}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);
        }

        @Test
        @DisplayName("Not Success - User does not exist")
        void test3() throws Exception {

            //Arrange
            Integer userId = 0;
            Integer userIdToFollow = 3;
            String responseBody = "{\"message\":\"No existe usuario con ID: " + userId + "\",\"statusCode\":400}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);

        }

        @Test
        @DisplayName("Not Success - User Seller does not exist")
        void test4() throws Exception {

            //Arrange
            Integer userId = 1;
            Integer userIdToFollow = 0;
            String responseBody = "{\"message\":\"No existe usuario con ID: " + userIdToFollow + "\",\"statusCode\":400}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);

        }

    }

    @Nested
    @DisplayName("IT - POST getUserFollowersCount")
    class getUserFollowersCount {

        @Test
        @DisplayName("Success")
        void test1() throws Exception {

            //Arrange
            Integer userId = 6;

            String responseBody = "{\n" +
                    "    \"user_id\": 6,\n" +
                    "    \"user_name\": \"Florencia\",\n" +
                    "    \"followers_count\": 4\n" +
                    "}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/users/{userId}/followers/count", userId);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedContentType, expectedJson);

        }

        @Test
        @DisplayName("Not Success - User does not Exist")
        void test2() throws Exception {

            //Arrange
            Integer userId = 60;

            String responseBody = "{\"message\":\"No existe usuario con ID: 60\",\"statusCode\":400}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .get("/users/{userId}/followers/count", userId);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedContentType, expectedJson);

        }
    }

}

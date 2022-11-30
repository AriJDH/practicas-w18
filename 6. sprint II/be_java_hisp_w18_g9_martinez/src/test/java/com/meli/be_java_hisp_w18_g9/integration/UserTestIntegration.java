package com.meli.be_java_hisp_w18_g9.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class UserTestIntegration {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IUserRepository userRepository;

    @Test
    @DisplayName("Test uri: /users/{userId}/followers/count ** user found **")
    void userFollowedQuantityUserFound() throws Exception {
        /* Arrange */
        User userTestExpect =
                new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userFollower1 =
                new User(2, "Janeth", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userFollower2 =
                new User(3, "Angel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userFollower3 =
                new User(4, "Valentina", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        List<User> userTargetFollowers =
                new ArrayList<>(List.of(userFollower1, userFollower2, userFollower3));
        userTestExpect.setFollowers(userTargetFollowers);
        when(userRepository.findById(userTestExpect.getUserId())).thenReturn(
                Optional.of(userTestExpect));

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent =
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", userTestExpect.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        expectedStatus,
                        expectedContent
                );
    }

    @Test
    @DisplayName("Test uri: /users/{userId}/followers/count ** user not found **")
    void userFollowedQuantityUserNotFound() throws Exception {
        /* Arrange */
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContent =
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 1)
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        expectedStatus,
                        expectedContent
                );

    }
    @Test
    @DisplayName("Test uri: /users/{userId}/followers/count ** user invalid **")
    void userFollowedQuantityUserInvalid() throws Exception {
        /* Arrange */

        /* Matchers */
        ResultMatcher expectStatus = MockMvcResultMatchers.status().isBadRequest();
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", "userInvalid")
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        expectStatus
                );
    }

    @Test
    @DisplayName("Test uri: /users/{userId}/follow/{userIdToFollow} ** user follow not found **")
    void followUserFollowNotFound() throws Exception {
        /* Arrange */
        User userTestExpect = new User(1, "Janeth", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(userTestExpect.getUserId())).thenReturn(
                Optional.of(userTestExpect));
        when(userRepository.findById(2)).thenReturn(Optional.empty());
        /* Matchers */
        ResultMatcher expectStatus = MockMvcResultMatchers.status().isNotFound();
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 2)
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpect(expectStatus);

    }
}

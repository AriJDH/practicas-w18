package com.example.SocialMeli2.integration;


import com.example.SocialMeli2.dto.respose.FollowDTORes;
import com.example.SocialMeli2.dto.respose.UnfollowDTORes;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@AutoConfigureMockMvc
@SpringBootTest
public class SocialMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test endpoint: follow")
    void followTest() throws Exception {
        //Arrange
        FollowDTORes followDTORes = new FollowDTORes();
        followDTORes.setUserNameFollowed("Ethan");
        followDTORes.setUserName("Josep");
        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(followDTORes);
        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/1/follow/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus , expectedContentType);
    }

    @Test
    @DisplayName("Test endpoint: unfollow")
    void unfollowTest() throws Exception{
        // Arange
        UnfollowDTORes unfollowDTORes= new UnfollowDTORes();
        unfollowDTORes.setUserName("Josep");
        unfollowDTORes.setUserNameUnfollowed("Ethan");
        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(unfollowDTORes);
        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/1/unfollow/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus , expectedContentType);
    }
}

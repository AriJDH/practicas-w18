package com.example.socialmeli2.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class PublicationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUserFollowedPublicationsById() throws Exception {
        // Arrange
//        MockHttpServletRequestBuilder requestPayload = Mock;
//        // Act & Assert
//        mockMvc.perform(requestPayload)
    }
}
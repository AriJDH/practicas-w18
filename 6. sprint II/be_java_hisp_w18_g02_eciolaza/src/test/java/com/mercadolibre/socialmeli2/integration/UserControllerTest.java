package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.repository.IUserRepository;

import ch.qos.logback.core.net.ObjectWriter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    IUserRepository userRepository;

    @Test
    public void unfollowTest() throws Exception {
        Integer userId = 1 ;
        Integer userIdToUnfollow = 3;
        ResponseDto responseDto = new ResponseDto("El usuario " + userId + " dejó de seguir al usuario " + userIdToUnfollow, 200);
        
        //convierto responseDto a Json
        String expectedResponseJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(responseDto);

        //creo Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
        .post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
        .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher expectedResponse = MockMvcResultMatchers.jsonPath("$.messages").value(responseDto.getMessages());
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //MvcResult mvcResult = this.
        mockMvc.perform(request)
        .andDo(print())
        .andExpectAll(expectedResponse, expectedStatus, expectedContent);
    }
}

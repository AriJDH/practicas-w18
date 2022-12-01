package com.socialmeli.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.request.ProductDTORequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration US-0005")
    void test1() throws Exception{
        // Arrange

        ProductDTORequest productDTORequest = new ProductDTORequest(1,"Producto","Producto","Brand","Blanco","Nota");
        NewPostDTORequest newPostDTORequest = new NewPostDTORequest(10,"30-11-2022",productDTORequest,5,1000D);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payload = writer.writeValueAsString(newPostDTORequest);

        // Matchers

        ResultMatcher expectedStatus = status().isOk();

        // Act & Assert

        mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpectAll(expectedStatus);

    }

    @Test
    @DisplayName("Integration Bonus US-0001")
    void test2() throws Exception {

        // Arrange

        Integer userId = 3;
        Integer userIdFollow = 30;

        // Matchers

        ResultMatcher expectedStatus = status().isOk();

        MockHttpServletRequestBuilder requestPayload = post("/users/{userId}/follow/{userIdToFollow}",userId,userIdFollow);

        // Act & Assert

        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }


    @Test
    @DisplayName("Integration Bonus US-0007")
    void test3() throws Exception {

        // Arrange

        Integer userId = 3;
        Integer userIdFollow = 60;

        //Matchers

        ResultMatcher expectedStatus = status().isOk();

        MockHttpServletRequestBuilder requestPaylod = post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdFollow);

        // Act & Assert

        mockMvc
                .perform(requestPaylod)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }



}
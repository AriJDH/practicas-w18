package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.request.ProductDTOReq;
import com.example.SocialMeli2.dto.respose.FollowDTORes;
import com.example.SocialMeli2.dto.respose.PostDTORes;
import com.example.SocialMeli2.dto.respose.ProductDTORes;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class Integration {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        // Arrange
        PostDTOReq postDTOReq = new PostDTOReq();
        postDTOReq.setUser_id(1);
        postDTOReq.setDate(LocalDate.of(2022, 10, 10));
        postDTOReq.setProduct(new ProductDTOReq(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition"));
        postDTOReq.setCategory(100);
        postDTOReq.setPrice(1500.50);

        PostDTORes postDTORes = new PostDTORes();
        postDTORes.setUser_id(1);
        postDTORes.setPost_id(11);
        postDTORes.setDate(postDTOReq.getDate());
        postDTORes.setProduct(new ProductDTORes(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition"));
        postDTORes.setCategory(100);
        postDTORes.setPrice(1500.50);

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        String postJson = mapper.writeValueAsString(postDTOReq);
        String payload = mapper.writeValueAsString(postDTORes);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
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
}

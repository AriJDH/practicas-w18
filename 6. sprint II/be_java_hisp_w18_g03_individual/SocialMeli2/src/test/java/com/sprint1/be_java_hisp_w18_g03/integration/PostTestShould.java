package com.sprint1.be_java_hisp_w18_g03.integration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.ProductRequestDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.service.PostServiceImp;
import com.sprint1.be_java_hisp_w18_g03.service.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sprint1.be_java_hisp_w18_g03.utils.PostFactory.*;
import static com.sprint1.be_java_hisp_w18_g03.utils.UserFactory.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class PostTestShould {
    @Autowired
    MockMvc mockMvc;

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @Mock
    PostServiceImp postServiceImp;


    @Test
    @DisplayName("US-0005: Dar de alta una nueva publicación.")
    void create_a_post() throws Exception {
        //Arrange
        RequestPostDTO requestPostDTO = getRequestPostDto(6);

        ResponseDTO response = new ResponseDTO("Post added successfully", 200);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String responseJson = objectMapper.writeValueAsString(response);
        String payload = objectMapper.writeValueAsString(requestPostDTO);

        //Matchers
        ResultMatcher expectedStatus = status().is(200);
        ResultMatcher expectedJson = content().json(responseJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder requestPayload = post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act y assert
        mockMvc.perform(requestPayload).andDo(print()).
                andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    @Test
    void getPostSellers() {
    }

    @Test
    void getOrderedPostsByDate() {
    }
}
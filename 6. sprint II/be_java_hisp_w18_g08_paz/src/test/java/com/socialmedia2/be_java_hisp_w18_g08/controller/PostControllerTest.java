package com.socialmedia2.be_java_hisp_w18_g08.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ExceptionDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ResponseMessasgeDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static com.socialmedia2.be_java_hisp_w18_g08.util.FactoryPost.*;
import static com.socialmedia2.be_java_hisp_w18_g08.util.FactoryUser.*;
import static com.socialmedia2.be_java_hisp_w18_g08.util.DBFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    PostRepositoryImp postRepositoryImp;
    @Autowired
    UserRepositoryImp userRepositoryImp;

    @BeforeEach
    private void setup(){
        userRepositoryImp.deleteAll();
        postRepositoryImp.deleteAll();
        createRepository(userRepositoryImp, postRepositoryImp);
    }

    @Order(1)
    @Test
    @DisplayName("T0009 - Create post OK")
    void createPostOk() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = createPost();
        ResponseMessasgeDto expectedDto = new ResponseMessasgeDto("Post created with success",200, LocalDate.now());

        String payload = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writeValueAsString(postDtoReq);

        // Act & Assert
        mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.status").value(expectedDto.getStatus()),
                        jsonPath("$.message").value(expectedDto.getMessage()),
                        jsonPath("$.timeStamp").value(expectedDto.getTimeStamp().toString()),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(2)
    @Test
    @DisplayName("T0009 - Create post NoOK")
    void createPostNoOk() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = createFailedPost();
        ExceptionDto expectedDto = new ExceptionDto(List.of("El Color no puede poseer caracteres especiales."),400, LocalDate.now());

        String payload = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writeValueAsString(postDtoReq);

        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value("El Color no puede poseer caracteres especiales."),
                        jsonPath("$.timeStamp").value(expectedDto.getTimeStamp().toString()),
                        status().isBadRequest(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(3)
    @Test
    @DisplayName("T00010 - Get posts list by user id")
    void getPostSellerListByUserId() throws Exception{
        // Arrange
        User user = createUser();
        PostDtoRes expectedDto = cretePostRes(user.getUser_id());

        String expectedJson= new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writeValueAsString(expectedDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", user.getUser_id())
                        .param("order","date_asc"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedJson,result.getResponse().getContentAsString());
    }

    @Order(4)
    @Test
    @DisplayName("T00010 - Get posts list by user id validation exception")
    void getPostSellerListByUserIdValidationException() throws Exception{
        // Arrange
        ExceptionDto expectedDto = new ExceptionDto(List.of("getPostSellerListByUserId.userId: El id debe ser mayor a cero"),404,LocalDate.now());

        System.out.println(expectedDto.getTimeStamp().toString());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", -1))
                .andDo(print())
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.message").value("getPostSellerListByUserId.userId: El id debe ser mayor a cero"),
                        jsonPath("$.timeStamp").value(expectedDto.getTimeStamp().toString()));
    }

    @Order(5)
    @Test
    @DisplayName("T00010 - Get posts list by user id exception")
    void getPostSellerListByUserIdException() throws Exception{
        // Arrange
        ExceptionDto expectedDto = new ExceptionDto(List.of("User with id: 10Not found"),404,LocalDate.now());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 10))
                .andDo(print())
                .andExpectAll(
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.message").value("User with id: 10Not found"),
                        jsonPath("$.timeStamp").value(expectedDto.getTimeStamp().toString()),
                        jsonPath("$.status").value(expectedDto.getStatus()));
    }
}
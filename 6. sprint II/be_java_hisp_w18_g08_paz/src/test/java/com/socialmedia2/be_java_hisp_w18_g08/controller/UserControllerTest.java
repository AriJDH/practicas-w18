package com.socialmedia2.be_java_hisp_w18_g08.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ExceptionDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ResponseMessasgeDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.SellerFollowersCountDto;
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

import static com.socialmedia2.be_java_hisp_w18_g08.util.DBFactory.createRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

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
    @DisplayName("T0011 - Follow OK")
    void followOk() throws Exception {
        //Arrange
        FollowDtoRes expectedDto = new FollowDtoRes(200,"User with id:1 already follow to Seller with id:6");

        String payload = new ObjectMapper()
                .writeValueAsString(expectedDto);

        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,6)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value(expectedDto.getMessage()),
                        content().contentType(MediaType.APPLICATION_JSON),
                        status().isOk());
    }

    @Order(2)
    @Test
    @DisplayName("T0011 - Follow NoOK")
    void followNoOk()throws Exception{
        //Arrange
        ExceptionDto expectedDto = new ExceptionDto(List.of("User with id: 10Not found"),404, LocalDate.now());

        String payload = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writeValueAsString(expectedDto);

        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",10,4)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value("User with id: 10Not found"),
                        status().isNotFound(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(3)
    @Test
    @DisplayName("T0012 - Unfollow OK")
    void unfollowOk() throws Exception {
        //Arrange
        ResponseMessasgeDto expectedDto = new ResponseMessasgeDto("User1 with id: 1 unfollow to -> User6 with id: 6", 200, LocalDate.now());

        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 6))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value(expectedDto.getMessage()),
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(4)
    @Test
    @DisplayName("T0012 - Unfollow NoOK")
    void unfollowNoOk() throws Exception {
        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 15, 6))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value("User with id:15 not found"),
                        status().isNotFound(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(5)
    @Test
    @DisplayName("T0013 - Followers Quantity OK")
    void followersQuantityOk() throws Exception {
        //Arrange
        SellerFollowersCountDto expectedDto = new SellerFollowersCountDto(6,"User6",4);

        String responseJson = new ObjectMapper()
                .writeValueAsString(expectedDto);

        // Act & Assert
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 6))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Order(6)
    @Test
    @DisplayName("T0013 - Followers Quantity NoOK")
    void followersQuantityNoOk() throws Exception {
        // Act & Assert
        mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 15))
                .andDo(print())
                .andExpectAll(
                        jsonPath("$.message").value("Not found User with id 15"),
                        status().isNotFound(),
                        content().contentType(MediaType.APPLICATION_JSON));
    }
}
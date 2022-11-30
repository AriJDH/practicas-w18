package com.socialmedia2.be_java_hisp_w18_g08.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ExceptionDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ProductDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.*;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import org.junit.jupiter.api.DisplayName;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    MockMvc mockMvc;


   @Test
   @DisplayName("Lista de seguidos exitoso =)")
    void getFollowed() throws Exception{
       //Arrange

       UserDto us = new UserDto(5,"User5");
       UserDto us2 = new UserDto(6,"User6");
       UserDto us3 = new UserDto(7,"User7");
       UserDto us4 = new UserDto(8,"User8");
       List<UserDto> lista =  Arrays.asList(us,us2,us3,us4);

       FollowedDto response = new FollowedDto(1,"User1",lista);
       String payload = new ObjectMapper().writeValueAsString(response);

       //Matchers

       ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(payload);

       //Act&Assert
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(expectedJson)
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Lista de seguidos No exitoso =(")
    void getFollowedBad() throws Exception{
        //Arrange
        List<String> ms = Arrays.asList("There is no user with the ID 11");
        ExceptionDto res = new ExceptionDto(ms,404,null);
        String payload = new ObjectMapper().writeValueAsString(res);

        //Matchers

        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(payload);

        //Act&Assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",11))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                .value("There is no user with the ID 11"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    @DisplayName( "Follow exitoso =)")
    void follow()throws Exception{
       //Arrange
        FollowDtoRes resDto = new FollowDtoRes(200,"User with id:1 already follow to Seller with id:5");
        String payload = new ObjectMapper().writeValueAsString(resDto);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/1/follow/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName( "Follow No exitoso =(")
    void followBad()throws Exception{
        //Arrange
        List<String> ms = Arrays.asList("User with id: 10Not found");
        ExceptionDto res = new ExceptionDto(ms,404,null);
        String payload = new ObjectMapper().writeValueAsString(res);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/10/follow/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpect(jsonPath("$.message")
                .value("User with id: 10Not found"))
                .andReturn();
    }

    @Test
    @DisplayName("Unfollow Exitoso =)")
    void unfollowUser() throws Exception {
       //Arrange
        ResponseMessasgeDto response = new ResponseMessasgeDto();

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    @DisplayName("Cantidad de seguidores exitoso =)")
    void findAllFollowersQuantity() throws Exception {
        /* Arrange */

        SellerFollowersCountDto response = new SellerFollowersCountDto(6,"User6",4);
        String responseJson = new ObjectMapper().writeValueAsString(response);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 6);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }


    //PostController
    @Test
    @DisplayName("Lista de vendedores Exitoso =)")
    void getPostSellerListByUserId()throws Exception{
       //Arrange

        List<PostDto> posts = new ArrayList<>();
        PostDtoRes response = new PostDtoRes();
        ProductDtoRes pr = new ProductDtoRes(1,"Product1","Type1","Brand1","Color1","Notes1");
        PostDto ps = new PostDto(3,7,pr,3,333.33,null);
        posts.add(ps);
        response.setUser_id(4);
        response.setPosts(posts);

        String pl = new ObjectMapper().writeValueAsString(response);
        String payload = pl.replace("null","02-12-2022");

        //Matchers

        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(payload);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 4))
                .andDo(print())
                .andExpectAll(expectedJson)
                .andReturn();
    }

}
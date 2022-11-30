package com.socialmedia2.be_java_hisp_w18_g08.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ExceptionDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.*;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Obtener lista seguidos Ascendentemente de forma exitosa ")
    void getFollowedAsc() throws Exception{
        //Arrange

        UserDto u5 = new UserDto(5,"User5");
        UserDto u6 = new UserDto(6,"User6");
        UserDto u7 = new UserDto(7,"User7");
        UserDto u8 = new UserDto(8,"User8");
        List<UserDto> listaUsuarios =  Arrays.asList(u5,u6,u7,u8);

        FollowedDto req = new FollowedDto(1,"User1",listaUsuarios);
        String payload = new ObjectMapper().writeValueAsString(req);

        //Matchers

        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(payload);

        //Act&Assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list",1)
                        .param("order","name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(expectedJson)
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("obtener cantidad de seguidores de forma exitosa ")
    void test() throws Exception {
        //
        SellerFollowersCountDto sellerFollowersCountDto = new SellerFollowersCountDto();
        sellerFollowersCountDto.setUser_id(5);
        sellerFollowersCountDto.setUser_name("User5");
        sellerFollowersCountDto.setFollowers_count(4);

        String expectedCount = new ObjectMapper().writeValueAsString(sellerFollowersCountDto);
        /*Matchers*/
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedCount);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        /*Request*/
        MockHttpServletRequestBuilder requestUrl = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count",5);
        // Act & assert
        mockMvc
                .perform(requestUrl)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);
    }

    @Test
    @DisplayName("Listar seguidores ascendente exitoso =)")
    void findUserListBySellerAsc()throws Exception{
        UserDto u1 = new UserDto(1,"User1");
        UserDto u2 = new UserDto(2,"User2");
        UserDto u3 = new UserDto(3,"User3");
        UserDto u4 = new UserDto(4,"User4");
        List<UserDto> followers =  Arrays.asList(u1,u2,u3,u4);

        UserListDto req = new UserListDto(6,"User6",followers);
        String responseJson = new ObjectMapper().writeValueAsString(req);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 6)
                .param("order","name_asc");

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    @Test
    @DisplayName("Obtener lista de seguidore de forma descendente, camino feliz")
    void findUserListBySellerDesc()throws Exception{
        UserDto u1 = new UserDto(1,"User1");
        UserDto u2 = new UserDto(2,"User2");
        UserDto u3 = new UserDto(3,"User3");
        UserDto u4 = new UserDto(4,"User4");
        List<UserDto> followers =  Arrays.asList(u1,u2,u3,u4);

        UserListDto response = new UserListDto(6,"User6",followers);
        String responseJson = new ObjectMapper().writeValueAsString(response);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 6)
                .param("order","name_desc");

        /* Act & Assert*/
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);


    }

    @Test
    @DisplayName("Obtener lista de vendedores de forma errónea")
    void getPostSellerListByUserIdBad()throws Exception{
        //Arrange
        List<String> ms = List.of("User with id: 5Not found");
        ExceptionDto res = new ExceptionDto(ms,404,null);
        String payload = new ObjectMapper().writeValueAsString(res);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/5/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        /* Act & Assert*/
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpect(jsonPath("$.message")
                        .value("User with id: 5Not found"))
                .andReturn();
    }

    @Test
    @DisplayName("Obtener lista de vendedores de forma ascendente y exitosa")
    void getPostSellerListByUserIdAsc()throws Exception{

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

        /*Matchers*/

        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(payload);

        /* Act & Assert*/
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 4)
                        .param("order","date_asc"))
                .andDo(print())
                .andExpectAll(expectedJson)
                .andReturn();
    }
    @Test
    @DisplayName( "HAcer follow de forma exitosa ")
    void follow()throws Exception{
        //Arrange
        FollowDtoRes resDto = new FollowDtoRes(200,"User with id:1 already follow to Seller with id:5");
        String payload = new ObjectMapper().writeValueAsString(resDto);

        /*Matchers*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /*Request*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/1/follow/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        /* Act & Assert*/
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName( "hacer follow erróneo")
    void followBad()throws Exception{
        //Arrange
        List<String> ms = List.of("User with id: 10Not found");
        ExceptionDto res = new ExceptionDto(ms,404,null);
        String payload = new ObjectMapper().writeValueAsString(res);

        /*Request*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/10/follow/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        /* Act & Assert*/
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpect(jsonPath("$.message")
                        .value("User with id: 10Not found"))
                .andReturn();
    }

    @Test
    @DisplayName("Hacer unfollo de forma exitosa")
    void unfollowUser() throws Exception {
        //Arrange
        ResponseMessasgeDto response = new ResponseMessasgeDto();

        /* Act & Assert*/
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
}

package com.dh.be_java_hisp_w18_g10.controller;


import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.exception.ExceptionConfig;
import com.dh.be_java_hisp_w18_g10.repository.PostRepository;
import com.dh.be_java_hisp_w18_g10.repository.UserRepository;
import com.dh.be_java_hisp_w18_g10.service.AppService;
import com.dh.be_java_hisp_w18_g10.util.GeneratorDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class AppControllerTest {
    private MockMvc mockMvc;

    //DE ESTA FORMA PUEDO EVITAR QUE LOS TEST SE VEAN AFECTADOS POR EL UNFOLLOW USER Y SEAN INDEPENDIENTES
    @BeforeEach
    public void setup() {
        this.mockMvc =
                MockMvcBuilders.standaloneSetup(
                        new AppController(
                                new AppService(new UserRepository(), new PostRepository())),
                        new ExceptionConfig()
                ).build();
    }

    @Test
    @DisplayName("US-0001: OK")
    void followUserTest() throws Exception {

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 2);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus);
    }

    @DisplayName("US-0001: Seguir a un usuario que NO es vendedor")
    @Test
    void followUserWithoutPostTest() throws Exception {

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 2, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("US-0002: OK")
    void getUserFollowersCountTest() throws Exception {

        UserFollowersCountDTOres countDTOres = GeneratorDB.getUserFollowersCountDTOres();

        String postJson = new ObjectMapper()
                .writeValueAsString(countDTOres);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 2)
                .content(MediaType.APPLICATION_JSON_VALUE);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US-0003: Order Name ASC")
    void getUserFollowersNameASCTest() throws Exception {

        UserFollowersListDTOres followersListDTOres = GeneratorDB.getUserFollowersListDTOresASC();

        String expect = new ObjectMapper().writeValueAsString(followersListDTOres);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 2)
                .param("order", "name_asc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US-0003: Order Name DESC")
    void getUserFollowersNameDESCTest() throws Exception {

        UserFollowersListDTOres followersListDTOres = GeneratorDB.getUserFollowersListDTOresDESC();

        String expect = new ObjectMapper().writeValueAsString(followersListDTOres);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 2)
                .param("order", "name_desc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }


    @Test
    @DisplayName("US-0004: Order Name ASC")
    void getUserFollowedASCTest() throws Exception {

        UserFollowedListDTOres userFollowedListDTOres = GeneratorDB.getUserFollowedListDTOresASC();

        String expect = new ObjectMapper().writeValueAsString(userFollowedListDTOres);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 1)
                .param("order", "name_desc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US-0004: Order Name DESC")
    void getUserFollowedDESCTest() throws Exception {

        UserFollowedListDTOres userFollowedListDTOres = GeneratorDB.getUserFollowedListDTOresDESC();

        String expect = new ObjectMapper().writeValueAsString(userFollowedListDTOres);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 1)
                .param("order", "name_desc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US-0005")
    void addPostTest() throws Exception {
        //ARRANGE
        PostDTOreq postDTOreq = GeneratorDB.getPostDTOreq();
        String postJson = new ObjectMapper().writeValueAsString(postDTOreq);

        /*Matchers*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();

        /*Request*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);

        //ACT AND ASSERT
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus)
                .andReturn();

    }

    @Test
    @DisplayName("US-0006: Order Date ASC")
    void getUserFollowedPostDateASCTest() throws Exception {
        //ARRANGE
        UserPostsDTOres userPostsDTOres = GeneratorDB.getUserPostsDTOresASC();
        String postJson = new ObjectMapper().writeValueAsString(userPostsDTOres);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 1)
                .param("order", "date_asc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US-0006: Order Date DESC")
    void getUserFollowedPostDateDESCTest() throws Exception {
        //ARRANGE
        UserPostsDTOres userPostsDTOres = GeneratorDB.getUserPostsDTOresDESC();
        String postJson = new ObjectMapper().writeValueAsString(userPostsDTOres);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 1)
                .param("order", "date_desc")
                .content(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(requestPayload)
                .andExpectAll(expectedStatus, expectedJson, expectedContentType)
                .andDo(print())
                .andReturn();
    }


    @Test
    @DisplayName("US-0007: Unfollow user")
    void unfollowedUserById() throws Exception {
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus);
    }

}


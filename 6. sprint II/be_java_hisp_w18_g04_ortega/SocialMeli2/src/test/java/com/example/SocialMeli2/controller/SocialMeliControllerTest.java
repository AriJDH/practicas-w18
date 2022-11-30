package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.respose.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SocialMeliControllerTest {

    @Autowired
    private MockMvc mvc;

    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void methodFollowTest() throws Exception{
        FollowDTORes followDTORes = new FollowDTORes();
        followDTORes.setUserName("Josep");
        followDTORes.setUserNameFollowed("Ethan");
        String responseJson = mapper.writeValueAsString(followDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}",1,2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);

        this.mvc.perform(response)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((MockMvcResultMatchers.jsonPath("$.userName").value("Josep")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userNameFollowed").value("Ethan"));
    }

    @Test
    void methodFollowersCountTest() throws Exception{
        FollowerCountDTORes followerCountDTORes = new FollowerCountDTORes();
        followerCountDTORes.setUser_id(2);
        followerCountDTORes.setUser_name("Ehan");
        followerCountDTORes.setFollowers_count(3);
        String responseJson = mapper.writeValueAsString(followerCountDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/count",2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);

        this.mvc.perform(response)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Ethan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(3));
    }

    @Test
    void methodGetFollowersTest() throws Exception {
        FollowerListDTORes followerListDTORes = new FollowerListDTORes();
        followerListDTORes.setUser_id(2);
        followerListDTORes.setUser_name("Ethan");
        List<UserDTORes> followers = new ArrayList<>();
        UserDTORes userDTORes1 = new UserDTORes(1,"Josep");
        UserDTORes userDTORes2 = new UserDTORes(3,"Louis");
        UserDTORes userDTORes3 = new UserDTORes(4,"Kevin");
        followers.add(userDTORes1);
        followers.add(userDTORes2);
        followers.add(userDTORes3);
        followerListDTORes.setFollowers(followers);
        String responseJson = mapper.writeValueAsString(followerListDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/list",2)
                .param("order","name_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);

        this.mvc.perform(response)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Ethan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", hasSize(3)));
    }


    }





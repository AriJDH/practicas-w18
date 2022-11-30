package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.respose.FollowDTORes;
import com.example.SocialMeli2.dto.respose.FollowerCountDTORes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void followersCount() throws Exception{
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
}




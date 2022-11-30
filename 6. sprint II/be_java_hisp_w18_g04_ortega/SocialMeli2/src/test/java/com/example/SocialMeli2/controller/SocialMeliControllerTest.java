package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.request.ProductDTOReq;
import com.example.SocialMeli2.dto.respose.*;
import com.example.SocialMeli2.service.IUserBuyerService;
import com.example.SocialMeli2.service.UserBuyerServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
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
        mapper.findAndRegisterModules();
    }

    @Test
    void methodFollowTest() throws Exception {
        FollowDTORes followDTORes = new FollowDTORes();
        followDTORes.setUserName("Josep");
        followDTORes.setUserNameFollowed("Ethan");
        String responseJson = mapper.writeValueAsString(followDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 2)
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
    void methodFollowersCountTest() throws Exception {
        FollowerCountDTORes followerCountDTORes = new FollowerCountDTORes();
        followerCountDTORes.setUser_id(2);
        followerCountDTORes.setUser_name("Ehan");
        followerCountDTORes.setFollowers_count(3);
        String responseJson = mapper.writeValueAsString(followerCountDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/count", 2)
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
        UserDTORes userDTORes1 = new UserDTORes(1, "Josep");
        UserDTORes userDTORes2 = new UserDTORes(3, "Louis");
        UserDTORes userDTORes3 = new UserDTORes(4, "Kevin");
        followers.add(userDTORes1);
        followers.add(userDTORes2);
        followers.add(userDTORes3);
        followerListDTORes.setFollowers(followers);
        String responseJson = mapper.writeValueAsString(followerListDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/list", 2)
                .param("order", "name_asc")
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

    @Test
    void methodGetFollowedTest() throws Exception {
        FollowedListDTORes followedListDTORes = new FollowedListDTORes();
        followedListDTORes.setUser_id(1);
        followedListDTORes.setUser_name("Josep");
        List<UserDTORes> followed = new ArrayList<>();
        UserDTORes userDTORes1 = new UserDTORes(2, "Ethan");
        followed.add(userDTORes1);
        followedListDTORes.setFollowed(followed);
        String responseJson = mapper.writeValueAsString(followedListDTORes);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{client_id}/followed/list", 1)
                .param("order", "name_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);

        this.mvc.perform(response)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Josep"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", hasSize(3)));
    }

    @Test
    void methodPublishPostTest() throws Exception {
        PostDTOReq postDTOReq = new PostDTOReq();
        postDTOReq.setUser_id(1);
        postDTOReq.setDate(LocalDate.of(2022, 11, 30));
        postDTOReq.setProduct(new ProductDTOReq(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition"));
        postDTOReq.setCategory(1);
        postDTOReq.setPrice(1300.00);

        PostDTORes postDTORes = new PostDTORes();
        postDTORes.setUser_id(1);
        postDTORes.setPost_id(11);
        postDTORes.setDate(postDTOReq.getDate());
        postDTORes.setProduct(new ProductDTORes(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition"));
        postDTORes.setCategory(1);
        postDTORes.setPrice(1300.00);

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        String postJson = mapper.writeValueAsString(postDTOReq);
        String payload = mapper.writeValueAsString(postDTORes);

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        mvc
                .perform(requestPayload)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(postJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void methodgetLastPostsTest() throws Exception {
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list",3)
                .param("order","date_asc")
                .contentType(MediaType.APPLICATION_JSON);
        mvc
                .perform(requestPayload)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts",hasSize(0)));
    }
}





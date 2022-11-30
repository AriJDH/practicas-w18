package com.bootcamp.be_java_hisp_w18_g06.integration;

import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationUserTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    User userBuyerNotFollower;
    User userSeller1;
    User userSeller2;
    User userBuyerFollower1;
    User userBuyerFollower2;

    @BeforeEach
    void beforeEach()
    {
        Post post = new Post();

        userBuyerNotFollower = new User(40, "user not follower test");
        userBuyerFollower1 = new User(20, "A1 user follower test");
        userBuyerFollower2 = new User(30, "Z2 user follower test");

        List<User> usersFollowers = new ArrayList<>();
        usersFollowers.add(userBuyerFollower1);
        usersFollowers.add(userBuyerFollower2);

        userSeller1 = new User(10,"A1 user buyer test");
        userSeller2 = new User(50,"Z2 user buyer test");

        List<User> usersFollowed = new ArrayList<>();
        usersFollowed.add(userSeller1);
        usersFollowed.add(userSeller2);

        userSeller1.setPosts(Collections.singletonList(post));
        userSeller1.setFollowers(usersFollowers);
        userBuyerFollower1.setFollowed(usersFollowed);
        userBuyerFollower2.setFollowed(usersFollowed);

        userRepository.updateUsers(userSeller1);
        userRepository.updateUsers(userBuyerFollower1);
        userRepository.updateUsers(userBuyerFollower2);
        userRepository.updateUsers(userBuyerNotFollower);
    }

    @Test
    void followUserTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}",
                userBuyerNotFollower.getUser_id(), userSeller1.getUser_id());

        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }

    @Test
    void unfollowUserTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/unfollow/{userIdToUnfollow}",
                userBuyerFollower1.getUser_id(), userSeller1.getUser_id());

        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }

    @Test
    void getFollowersCountTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowersCount = MockMvcResultMatchers.jsonPath("$.followers_count")
                .value(2);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count",
                userSeller1.getUser_id());

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowersCount);
    }

    @Test
    void getFollowedListTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowed = MockMvcResultMatchers.jsonPath(
                "$.followed[?(@.user_id == \"" + userSeller1.getUser_id()
                        + "\" && @.user_name == \"" + userSeller1.getUser_name() + "\")]").exists();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                userBuyerFollower1.getUser_id());

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowed);
    }

    @Test
    void getFollowedListWithOrderAscTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowedFirst = MockMvcResultMatchers.jsonPath(
                "$.followed[0].user_name").value(userSeller1.getUser_name());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                userBuyerFollower1.getUser_id())
                .param("order","name_asc");

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowedFirst);
    }

    @Test
    void getFollowedListWithOrderDescTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowedFirst = MockMvcResultMatchers.jsonPath(
                "$.followed[0].user_name").value(userSeller2.getUser_name());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                userBuyerFollower1.getUser_id())
                .param("order","name_desc");

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowedFirst);
    }

    @Test
    void getFollowersListTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollower = MockMvcResultMatchers.jsonPath(
                "$.followers[?(@.user_id == \"" + userBuyerFollower1.getUser_id()
                        + "\" && @.user_name == \"" + userBuyerFollower1.getUser_name() + "\")]").exists();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                userSeller1.getUser_id());

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollower);
    }

    @Test
    void getFollowersListWithOrderAscTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowerFirst = MockMvcResultMatchers.jsonPath(
                "$.followers[0].user_name").value(userBuyerFollower1.getUser_name());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                userSeller1.getUser_id())
                .param("order", "name_asc");

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowerFirst);
    }

    @Test
    void getFollowersListWithOrderDescTest() throws Exception
    {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedFollowerFirst = MockMvcResultMatchers.jsonPath(
                "$.followers[0].user_name").value(userBuyerFollower2.getUser_name());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                userSeller1.getUser_id())
                .param("order", "name_desc");

        mockMvc.perform(request)
                .andExpect(expectedContentType)
                .andExpect(expectedStatus)
                .andExpect(expectedFollowerFirst);
    }
}

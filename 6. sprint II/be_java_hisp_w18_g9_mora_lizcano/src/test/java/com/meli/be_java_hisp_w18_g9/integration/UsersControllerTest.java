package com.meli.be_java_hisp_w18_g9.integration;

import com.jayway.jsonpath.JsonPath;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest


class UsersControllerTest {

@Autowired
MockMvc mockMvc;

@MockBean
    IUserRepository userRepository;
    @Test
    @DisplayName("Get all users followed by a user - Without filter order")
    void userFollowedListOrder() throws Exception {

        User user = new User(1, "Ian", new ArrayList<>(),
                List.of(
                        new User(2, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())

                ), new ArrayList<>());

       when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        this.mockMvc.perform(
                MockMvcRequestBuilders.
                get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Ian"))
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed[0].user_id").value(2))
                .andExpect(jsonPath("$.followed[0].user_name").value("Pedro"));



    }

    @Test
    @DisplayName("Get count of followers of a user")
    void userFollowedQuantity() {
    }

    @Test
    @DisplayName("Get all users follower by a user - Without filter order")
    void userFollowerList() {
    }

    @Test
    @DisplayName("Follow a user")
    void follow() {
    }

    @Test
    @DisplayName("Unfollow a user")
    void unfollowUser() {
    }
}
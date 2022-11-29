package com.sprint1.be_java_hisp_w18_g03.integration.controller;

import com.sprint1.be_java_hisp_w18_g03.controller.UserController;
import com.sprint1.be_java_hisp_w18_g03.dto.response.*;
import com.sprint1.be_java_hisp_w18_g03.service.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserServiceImp userServiceImp;

    @Test
    void followerCountNoOk() throws Exception {
        //ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/followers/count",-1))
                .andExpect(status().isBadRequest());
    }

    @Test
    void follow() throws Exception {
        //ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",anyInt(),anyInt()))
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedList() throws Exception {
        //ACT & ASSERT
         mockMvc.perform(get("/users/{userId}/followed/list",1,null))
                .andExpect(status().isOk());
    }

    @Test
    void unfollow() throws Exception {
        //ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",anyInt(),anyInt()))
                .andExpect(status().isOk());
    }

    @Test
    void getListFollowers() throws Exception {
        //ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/followers/list",1,null))
                .andExpect(status().isOk());
    }
}
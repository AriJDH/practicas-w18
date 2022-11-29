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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void followerCountNoOk() throws Exception {
        //ACT & ASSERT
        this.mockMvc.perform(get("/users/{userId}/followers/count",-1))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void userFollowHimself() throws Exception {
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",0,0))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFollowersListNoOk() throws Exception {
        this.mockMvc.perform(get("/users/{userId}/followers/list",-1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFollowedListNoOk() throws Exception {
        this.mockMvc.perform(get("/users/{userId}/followed/list",-1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
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
    void followerCount() throws Exception {
        //ARRANGE
        FollowerCountDTO followerCountDTO = new FollowerCountDTO(1,"juan",1);
        when(userServiceImp.followerCount(any())).thenReturn(followerCountDTO);
        //ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/followers/count",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void follow() throws Exception {
        //ARRANGE
        ResponseDTO responseDTO = new ResponseDTO();
        when(userServiceImp.follow(anyInt(),anyInt())).thenReturn(responseDTO);
        //ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",anyInt(),anyInt()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFollowedList() throws Exception {
        //ARRANGE
        List<UserDTO> followed = new ArrayList<>();
        followed.add(new UserDTO(2,"juan"));
        FollowedDTO followedDTO = new FollowedDTO(1,"",followed);

        //ACT & ASSERT
        when(userServiceImp.getFollowedList(1,null)).thenReturn(followedDTO);

         mockMvc.perform(get("/users/{userId}/followed/list",1,null))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void unfollow() throws Exception {
        //ARRANGE
        ResponseDTO responseDTO = new ResponseDTO();
        when(userServiceImp.unfollow(anyInt(),anyInt())).thenReturn(responseDTO);
        //ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",anyInt(),anyInt()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getListFollowers() throws Exception {
        //ARRANGE
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(2,"juan"));
        FollowersDTO followersDTO = new FollowersDTO(1,"",followers);

        //ACT & ASSERT
        when(userServiceImp.getFollowersList(1,null)).thenReturn(followersDTO);

        mockMvc.perform(get("/users/{userId}/followers/list",1,null))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
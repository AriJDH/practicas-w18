package com.example.socialmeli2.controller;

import com.example.socialmeli2.dto.response.UserFollowerCountResponse;
import com.example.socialmeli2.entity.UserEntity;
import com.example.socialmeli2.repository.IUserRepository;
import com.example.socialmeli2.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
   private MockMvc mockMvc;

    private IUserRepository  userRepository;

    @DisplayName("Testea el Endpoint /users/{userId}/followers/count")
    @Nested
    class followersCount{

        @BeforeEach
        void initialize(){

            Map<Integer, UserEntity> usersMap = new HashMap<>();

//        usersMap.put(1, new UserEntity(1, "Alice", Arrays.asList(2,3), Arrays.asList(), Arrays.asList(100,101,102))) ;
//        usersMap.put(2, new UserEntity(2, "Bob", Arrays.asList(4,5), Arrays.asList(1), Arrays.asList(110,111,112))) ;
//        usersMap.put(3, new UserEntity(3, "Charly", Arrays.asList(4,5), Arrays.asList(1), Arrays.asList(120,121,122))) ;
//        usersMap.put(4, new UserEntity(4, "Dennys", Arrays.asList(1,2), Arrays.asList(2,3), Arrays.asList(130,131,132))) ;
//        usersMap.put(5, new UserEntity(5, "Edgar", Arrays.asList(2), Arrays.asList(3), Arrays.asList(140,141,142))) ;
            usersMap.put(1, new UserEntity(1, "Carlos", new ArrayList<>(), new ArrayList<>(Arrays.asList(2)), new ArrayList<>()));
            usersMap.put(2, new UserEntity(2, "Felipe", new ArrayList<>(Arrays.asList(1)), new ArrayList<>(), new ArrayList<>()));
            usersMap.put(3, new UserEntity(3, "Maria", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            usersMap.put(4, new UserEntity(4, "Elisa", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            usersMap.put(5, new UserEntity(5, "Raul", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            usersMap.put(6, new UserEntity(6, "Florencia", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));



            userRepository = new UserRepositoryImpl(usersMap);
        }

        @DisplayName("Succesfull Execution")
        @Test
        void getUserFollowersCount()throws Exception{
            Integer testUserId = 1;
            Integer realFollowers = userRepository.getEntityById(testUserId).getFollowersList().size();
            String realName = userRepository.getEntityById(testUserId).getName();
            UserFollowerCountResponse userFollowerCountResponse = new UserFollowerCountResponse(testUserId, realName,realFollowers);

            ObjectWriter ow = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer()
                    .withDefaultPrettyPrinter();

            String expectedResponse = ow.writeValueAsString(userFollowerCountResponse);

//        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", testUserId))
            mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", testUserId))
                    .andDo(print())
                    .andExpect(content().json(expectedResponse))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        }
        @DisplayName("Not Found / Non Existent")
        @Test
        void getUserFollowersCountBadRequest()throws Exception{
            Integer testUserId = 999;
            mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", testUserId))
                    .andDo(print())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());

        }
        @DisplayName("Fail Validation")
        @Test
        void getUserFollowersCountValidationFail()throws Exception{
            Integer testUserId = 0;

          assertThrows(Exception.class, ()-> mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", testUserId))
                  .andDo(print())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(status().isBadRequest())) ;

        }
    }


    @DisplayName("Testea el Endpoint /users/{userId}/follow/{userIdToFollow}")
    @Nested
    class followUser{
        @Autowired UserRepositoryImpl userRepository;
        @DisplayName("Succesfull Execution")
        @Test
        void followUser()throws Exception{
            Integer testSeguidor = 4;
            Integer testSeguido = 3;

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", testSeguidor, testSeguido))
                    .andDo(print())
                    .andExpect(status().isOk());

            assertEquals(userRepository.getEntityById(testSeguido).getFollowersList().size(), 1);
        }
        @DisplayName("Unsuccesful Execution - NonExistant ID")
        @Test
        void followUserError()throws Exception{
            Integer testSeguidor = 50;
            Integer testSeguido = 333;

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", testSeguidor, testSeguido))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }


    @DisplayName("Testea el Endpoint /users/{userId}/unfollow/{userIdToFollow}")
    @Nested
    class unfollowUser{
        @Autowired UserRepositoryImpl userRepository;
        @DisplayName("Succesfull Execution")
        @Test
        void unfollowUser()throws Exception{
            Integer testSeguidor = 2;
            Integer testSeguido = 1;

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", testSeguidor, testSeguido))
                    .andDo(print())
                    .andExpect(status().isOk());

            assertEquals(userRepository.getEntityById(testSeguido).getFollowersList().size(), 0);
        }
        @DisplayName("Unsuccesful Execution - NonExistant ID")
        @Test
        void unfollowUserError()throws Exception{
            Integer testSeguidor = 50;
            Integer testSeguido = 333;

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", testSeguidor, testSeguido))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }

}
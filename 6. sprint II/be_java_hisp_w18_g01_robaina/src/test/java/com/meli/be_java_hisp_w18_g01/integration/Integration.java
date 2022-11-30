package com.meli.be_java_hisp_w18_g01.integration;


import com.meli.be_java_hisp_w18_g01.exceptions.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class Integration {

    @Autowired
    MockMvc mockMvc;
    ResultMatcher expectedStatusOk = MockMvcResultMatchers.status().is(200);
    @Test
    @DisplayName("Seguir a un usuario")
    public void follow() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(print())
                .andExpect(expectedStatusOk);

    }
    @Test
    @DisplayName("Dejar de seguir a un usuario")
    public void unfollow() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 3,2))
                .andDo(print())
                .andExpect(expectedStatusOk);
    }

    @Test
    @DisplayName("Seguir a un usuario que no existe")
    public void followNonExistUser() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}",1,20))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(404));
    }
    /*@Test
    @DisplayName("Ver seguidores de un usuario")
    public void getUserFollowers() throws Exception{

        /* matchers */
        /*ResultMatcher statusExpected = MockMvcResultMatchers.status().is(200);

        UserDTO miguel = new UserDTO(2L,"miguel");
        UserDTO laura = new UserDTO(3L,"laura");
        UserFollowersInfoDTO userFollowersInfo = new UserFollowersInfoDTO();
        userFollowersInfo.setUser_id(1L);
        userFollowersInfo.setUser_name("lucas");
        userFollowersInfo.setFollowers(List.of(miguel,laura));

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/users/{userId}/followers/list",1))
                .andDo(print())
                .andExpect(statusExpected)
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(userFollowersInfo)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
      }*/
    }




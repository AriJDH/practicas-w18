package com.dh.be_java_hisp_w18_g10.integration;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedListDTOres;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class Integration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Caso de dejar de seguir a un usuario")
    public void unfollowedUserById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Usuarios que sigo")
    public void getUserFollowedList() throws Exception {
        UserFollowedListDTOres result = new UserFollowedListDTOres();
        result.setUser_id(1);
        result.setUser_name("usuario1");
        result.setFollowed(List.of(new UserDTOres(2, "usuario2"),
                new UserDTOres(3, "usuario3")));

        String resultAsString = new ObjectMapper().writeValueAsString(result);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resultAsString))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentType(MediaType.APPLICATION_JSON));
    }
}

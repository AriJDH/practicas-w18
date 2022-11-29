package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter objectWriter;

    @BeforeEach
    public void setUp(){
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer();

    }

    @Test
    @DisplayName("Individual Test - /users/{userId}/follow/{userIdToFollow}")
    void shouldFollowASeller() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,4))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Individual Tests - /users/{userId}/followers/count")
    void shouldGetACountOfUserFollowers() throws Exception {
        UserFollowersCountDTOres userFollowersCountDTOres = new UserFollowersCountDTOres(2,"usuario2",2);
        String recipeJson = objectWriter.writeValueAsString(userFollowersCountDTOres);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(recipeJson));
    }

    @Test
    @DisplayName("Individual Tests - /users/{userId}/followers/list")
    void shouldGetAListOfUserFollowers() throws Exception {
        List<UserDTOres> listOfUsers = new ArrayList<>();
        listOfUsers.add(new UserDTOres(1,"usuario1"));
        listOfUsers.add(new UserDTOres(3,"usuario3"));
        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres(2,"usuario2",listOfUsers);
        String recipeJson = objectWriter.writeValueAsString(userFollowersListDTOres);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(recipeJson));
    }

}
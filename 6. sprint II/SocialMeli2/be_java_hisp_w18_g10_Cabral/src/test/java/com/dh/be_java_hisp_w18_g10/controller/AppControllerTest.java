package com.dh.be_java_hisp_w18_g10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Individual Test - /users/{userId}/follow/{userIdToFollow}")
    void shouldFollowASeller() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,4))
                .andExpect(status().isOk());
    }
}
package com.sprint1.be_java_hisp_w18_g03.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.service.PostServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PostServiceImp postServiceImp;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    @Test
    void createPost() throws Exception {
        //ACT & ASSERT
        RequestPostDTO requestPostDTO = new RequestPostDTO(1, LocalDate.now(), null, 1, 100d, false, 0d);
        mockMvc.perform(
                        post("/products/post")
                                .content(objectMapper.writeValueAsString(requestPostDTO))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void getPostSellers() throws Exception {
        //ACT & ASSERT
        mockMvc.perform(
                        get("/products/followed/{userId}/list", 1, null)
                )
                .andExpect(status().isOk());
    }
}
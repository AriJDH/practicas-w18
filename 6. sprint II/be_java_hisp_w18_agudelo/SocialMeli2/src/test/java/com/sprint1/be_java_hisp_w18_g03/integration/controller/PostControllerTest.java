package com.sprint1.be_java_hisp_w18_g03.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w18_g03.dto.request.ProductRequestDTO;
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

import static com.sprint1.be_java_hisp_w18_g03.utils.PostFactory.getRequestPostDTO;
import static com.sprint1.be_java_hisp_w18_g03.utils.PostFactory.getRequestPostDTOWithCategoryNull;
import static com.sprint1.be_java_hisp_w18_g03.utils.ProductFactory.getProduct;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    @Test
    void createPostOk() throws Exception {
        //ARRANGE
        RequestPostDTO requestPostDTO = getRequestPostDTO();
        //ACT & ASSERT
        mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestPostDTO))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void createPostNoOk() throws Exception {
        //ARRANGE
        RequestPostDTO requestPostDTO = getRequestPostDTOWithCategoryNull();
        //ACT & ASSERT
        mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestPostDTO))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    void getPostSellersNoOk() throws Exception {
        //ACT & ASSERT,"
        mockMvc.perform(
                        get("/products/followed/{userId}/list", -1)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter objectWriter;
    private String jsonBody;

    @BeforeEach
    public void setUp(){
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("Create a Post - /products/post")
    void shouldCreateAPost() throws Exception {
        ProductDTOreq productDto = new ProductDTOreq(
                1, "Silla Gamer", "Silla", "Besto Silla", "Marron", "Ergonomica"
        );
        PostDTOreq postDto = new PostDTOreq(
                1, "27-11-2022", productDto, 2, 100.0);

        jsonBody = objectWriter.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Bad Request when Create a Post - /products/post")
    void shouldThrowErrorWhenCreateAPost() throws Exception {
        ProductDTOreq productDto = new ProductDTOreq(
                1, "Silla$Gamer", "Silla", "Besto Silla", "Marron", "Ergonomica"
        );
        PostDTOreq postDto = new PostDTOreq(
                1, "27-11-2022", productDto, 2, 100.0);

        jsonBody = objectWriter.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get followers count - /users/{userId}/followers/count")
    void shouldGetUserFollowersCount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("usuario_2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2));
    }

}

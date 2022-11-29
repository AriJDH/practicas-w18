package com.bootcamp.be_java_hisp_w18_g06.integration;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.ProductReqDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class Integration {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1 () throws Exception {
        // Arrange
        ProductReqDTO product = new ProductReqDTO(
                1,
                "Estampa criadores",
                "Alimento",
                "Estampa",
                "marron",
                "presentacion bolsa grande"
                );
        PostDTO post = new PostDTO(
                1,
                LocalDate.now(),
                product,
                "mascotas",
                3000.00
        );

        //String payload= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(requestPostDto)
        String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
       // ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);

        //ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"));

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);


    }
}

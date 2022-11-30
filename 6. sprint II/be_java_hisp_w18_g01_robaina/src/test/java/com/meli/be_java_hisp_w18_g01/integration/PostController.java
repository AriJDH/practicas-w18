package com.meli.be_java_hisp_w18_g01.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ProductDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PostController {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Hacer un post")
    public void follow() throws Exception {
        // Arrange
        ResponseDTO response = new ResponseDTO(200,"operación exitosa");
        String responseString = new ObjectMapper().writeValueAsString(response);
        ProductDTO zapatillas = new ProductDTO(10L,"zapas","white","adidas","blanco","buenisimas");
        PostDTO post1  = new PostDTO(1L,"10-11-2022",zapatillas,10,2000.00);
        String payload = new ObjectMapper().writeValueAsString(post1);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is(200);
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act y Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

}

package com.meli.be_java_hisp_w18_g01.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ProductDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import com.meli.be_java_hisp_w18_g01.dtos.SellerDTO;
import org.junit.jupiter.api.DisplayName;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T0009 - Creando un post con todos los datos requeridos")
    void createPostOk() throws Exception {
        //Arrange
        ProductDTO product = new ProductDTO(1L, "Zapatillas", "Zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        PostDTO post = new PostDTO(1L, "22-11-2022",product,100, 20000D);

        String payload = new ObjectMapper().writeValueAsString(post);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.
                content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("T0009 - Creando un post con datos incorrectos")
    void createPostBad() throws Exception {
        //Arrange
        ProductDTO product = new ProductDTO(1L, "Zapatillas", "Zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        PostDTO post = new PostDTO(1L, "fecha equivocada",product,100, 20000D);

        String payload = new ObjectMapper().writeValueAsString(post);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.
                content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("T0010 - Obteniendo la lista de vendedores que sigue un usuario, con restricción de fecha del post")
    void getRecentPostsFromFollowedOk() throws Exception {

        //Arange
        ProductDTO product = new ProductDTO(1L, "Zapatillas", "Zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        PostDTO post1 = new PostDTO(1L, "20-11-2022", product, 100, 20000D);
        PostDTO post2 = new PostDTO(1L, "29-11-2022", product, 100, 20000D);
        List<PostDTO> posts = Arrays.asList(post1, post2);

        SellerDTO vendedor = new SellerDTO(1L, posts);
        List<SellerDTO> vendedoresExpect = Arrays.asList(vendedor);

        Long id = 2L;
        String expect = new ObjectMapper().writeValueAsString(vendedoresExpect);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.
                content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", id)
                .param("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("T0010 - Obteniendo la lista de vendedores que sigue un usuario que no existe")
    void getRecentPostsFromFollowedBad() throws Exception {

        //Arange
        Long id = 5L;
        ResponseDTO responseExpect = new ResponseDTO(404, "El usuario " + id + " no existe.");

        String expect = new ObjectMapper().writeValueAsString(responseExpect);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers.
                content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", id)
                .contentType(MediaType.APPLICATION_JSON);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}
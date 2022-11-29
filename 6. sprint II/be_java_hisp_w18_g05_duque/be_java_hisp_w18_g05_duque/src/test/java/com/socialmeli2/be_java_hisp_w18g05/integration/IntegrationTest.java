package com.socialmeli2.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.ProductDTORequest;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test //Test for verify the creation of a post
    void testAddPost () throws Exception {
        NewPostDTORequest post = new NewPostDTORequest();
        ProductDTORequest product = new ProductDTORequest();

        product.setProduct_id(1);
        product.setProduct_name("Silla");
        product.setType("Gamer");
        product.setBrand("Racer");
        product.setColor("Red");
        product.setNotes("Special edition");

        post.setUser_id(10);
        post.setDate("22-11-2022");
        post.setProduct(product);
        post.setCategory(1000);
        post.setPrice(1500.50);

        String payload = new ObjectMapper().writeValueAsString(post);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }
}

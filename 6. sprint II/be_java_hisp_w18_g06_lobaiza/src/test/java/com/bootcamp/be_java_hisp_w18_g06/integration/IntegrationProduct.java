package com.bootcamp.be_java_hisp_w18_g06.integration;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationProduct {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter objectWriter;

    @BeforeAll
    static void setUp()
    {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void IntegrationSaveOk() throws Exception
    {
        ProductReqDTO product = new ProductReqDTO();
        product.setProduct_id(1);
        product.setProduct_name("aaaa");
        product.setType("aaaa");
        product.setBrand("aaaa");
        product.setColor("aaaa");
        product.setNotes("bbbbb");

        PostDTO post = new PostDTO();
        post.setUser_id(1);
        post.setDate(LocalDate.now());
        post.setProduct(product);
        post.setCategory("10");
        post.setPrice(200.0);

        String postJson = objectWriter.writeValueAsString(post);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);

        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }

    @Test
    void IntegrationSaveNoProductAttr() throws Exception
    {
        ProductReqDTO product = new ProductReqDTO();

        PostDTO post = new PostDTO();
        post.setUser_id(1);
        post.setDate(LocalDate.now());
        post.setProduct(product);
        post.setCategory("10");
        post.setPrice(200.0);

        String postJson = objectWriter.writeValueAsString(post);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);

        MvcResult result =  mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andReturn();
    }
}

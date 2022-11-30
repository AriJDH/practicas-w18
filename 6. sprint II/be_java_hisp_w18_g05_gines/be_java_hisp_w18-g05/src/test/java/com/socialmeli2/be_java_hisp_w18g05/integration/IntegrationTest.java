package com.socialmeli2.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.ProductDTORequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testUS0005 () throws Exception {
        //======= Arrange =======
        ProductDTORequest productDTORequest = new ProductDTORequest(1,"product_name","type","brand", "color","notes");
        NewPostDTORequest postDto = new NewPostDTORequest(10, "29-11-2022", productDTORequest, 10, 20D);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(postDto);
        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andReturn();
        //======= Assert =======
        assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void valitionTest()throws Exception{
        UserDto userDto = new UserDto("Martin","Marquez",123);

        ErrorDto errorDto = new ErrorDto("No puede tener mas de 99 years.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(userDto);
        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult= mockMvc.perform(post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andReturn();

        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
    }
}

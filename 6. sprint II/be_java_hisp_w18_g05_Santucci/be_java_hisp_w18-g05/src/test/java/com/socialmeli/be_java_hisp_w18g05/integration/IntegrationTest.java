package com.socialmeli.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.request.ProductDTORequest;
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

    @Test
    void test1() throws Exception {
        // Arrange
        String date = "29-11-2022";
        ProductDTORequest product = new ProductDTORequest(1, "Producto 1", "type", "brand", "color", "notes");
        NewPostDTORequest postDto = new NewPostDTORequest(10,  date, product,  4, 20.0);

        String payload = new ObjectMapper().writeValueAsString(postDto);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }
    /*
    @PostMapping("/products/post") //US0005
    public ResponseEntity<?> addPost(@RequestBody @Valid NewPostDTORequest post){
        service.newPost(post);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    */

}

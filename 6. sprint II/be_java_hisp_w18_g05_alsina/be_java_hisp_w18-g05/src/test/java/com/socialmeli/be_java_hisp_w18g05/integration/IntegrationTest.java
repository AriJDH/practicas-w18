package com.socialmeli.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.request.ProductDTORequest;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0005 - Create Post")
    void IntegrationTest() throws Exception{

        //Arrange

        ProductDTORequest productDTO = new ProductDTORequest(
                1,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Red y Black");
        NewPostDTORequest postDTO = new NewPostDTORequest(
                10,
                "30-11-2022",
                productDTO,
                100,
                1500.50);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonNewPost= objectMapper.writeValueAsString(postDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder requestJsonNewPost = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonNewPost);

        //Act & Assert
        mockMvc
                .perform(requestJsonNewPost)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus);
    }

    //@PostMapping("/products/post") //US0005
    //public ResponseEntity<?> addPost(@RequestBody @Valid NewPostDTORequest post){
      //  service.newPost(post);
        //return new ResponseEntity<>( HttpStatus.OK);
   // }

}

package com.bootcamp.be_java_hisp_w18_g06.integration;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository.getAllUsers;
import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class Integration {

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveOk () throws Exception {
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
        String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(postJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson ,expectedContentType);
    }
    @Test
    //Si mando mal el postDTO controlar que devuelva un 400
    void saveNotOk () throws Exception {
        // Arrange
        ProductReqDTO product = new ProductReqDTO();
        PostDTO post = new PostDTO(
                1,
                LocalDate.now(),
                product,
                "mascotas",
                3000.00
        );
        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }
    @Test
    void findAllByUserOk() throws Exception {
        // Arrange
        //recibe un user con posts
        User user = getUserWithFollowersListAndPostsDTO("Humita");

        User user1 = getAllUsers().get(0);
        user1.setUser_id(1);
        user1.setFollowed(Arrays.asList(user));

        user.setFollowers(Arrays.asList(user1));

        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user1);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.get("/products/followed/"+user1.getUser_id()+"/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus ,expectedContentType);
    }

    @Test
    @DisplayName("User does not follow Sellers")
    void findAllByUserNotOk() throws Exception {
        // Arrange
        //recibe un user con posts
        User user = getUserWithFollowersListAndPostsDTO("Humita");
        user.setUser_id(5);

       // User user1 = getAllUsers().get(0);
       // user1.setUser_id(1);
       // user1.setFollowed(Arrays.asList(user));

      //  user.setFollowers(Arrays.asList(user1));

        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.get("/products/followed/"+user.getUser_id()+"/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus ,expectedContentType);
    }


}

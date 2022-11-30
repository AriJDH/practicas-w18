package com.meli.be_java_hisp_w18_g9.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;

import net.minidev.json.parser.JSONParser;
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

import java.util.List;


//-------Test class reference
@SpringBootTest

// ----- Inject method MockMvc
@AutoConfigureMockMvc

public class ProductsIntegrationTest {

    // ? ================= Attributes ================= ?

    //---- Inject dependencies
    @Autowired
    private MockMvc mockMvc;

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("Test integration for products findAll. ")
    void productsfindAll() throws Exception {

        //--------------------- Arrange ------------------------------------------------------

        //------Create new post with products
        Post postTest1 = new Post(1,1,LocalDate.now(),new Product(1,"Prueba", "Prueba", "Prueba", "Prueba","Prueba"),1, 4545.8282, true,654.654 );
        Post postTest2 = new Post(1,1,LocalDate.now(),new Product(1,"Prueba", "Prueba", "Prueba", "Prueba","Prueba"),2, 4545.8282, true,654.654 );

        //-------Create post list
        List<Post> listPost = new ArrayList<>();

        //----- Add post to list
        listPost.add(postTest1);
        listPost.add(postTest2);

        //------- Convert to Json
        JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // ----------------------------------------------------- Act -----------------------------------------------------



        //-------- Body that recibe in postman
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/products/post")
                .accept(MediaType.APPLICATION_JSON);

        // ----------------------------------------------------- Assert -----------------------------------------------------

        mockMvc
                .perform((requestPayload))   //--- Recibe Json
                .andExpect(expectedStatus)  //---- Result
                .andReturn();

    }

    @Test
    @DisplayName("Test integration for findFollowedByUserId. ")
    void findFollowedByUserId() throws Exception {

    }

}

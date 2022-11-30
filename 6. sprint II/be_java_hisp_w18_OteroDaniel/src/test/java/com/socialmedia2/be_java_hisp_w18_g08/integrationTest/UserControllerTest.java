package com.socialmedia2.be_java_hisp_w18_g08.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.utils.Repositories;
import org.junit.jupiter.api.BeforeEach;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private PostRepositoryImp postRepo;
    @Autowired
    private UserRepositoryImp userRepo;



    @BeforeEach
    void setUp() {
        Repositories.resetRepos(postRepo, userRepo);
    }

    @Test
    @DisplayName("T-0011 - Un usuario sigue correctamente a otro")
    void followOk() throws Exception{
        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.get("/products/followed/1/list");
        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

}

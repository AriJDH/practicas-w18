package com.socialmedia2.be_java_hisp_w18_g08.integration;

import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.utils.Repositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private PostRepositoryImp postRepositoryImp;
    @Autowired
    private UserRepositoryImp userRepositoryImp;

    @BeforeEach
    void setup(){
        Repositories.resetRepos(postRepositoryImp, userRepositoryImp);
    }
    @Test
    public void getPostSellerListByUserIdTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1));
    }
    
}

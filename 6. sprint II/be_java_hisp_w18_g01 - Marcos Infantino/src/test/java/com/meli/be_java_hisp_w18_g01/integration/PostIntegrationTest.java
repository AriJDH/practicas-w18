package com.meli.be_java_hisp_w18_g01.integration;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void cleanAndSetup(){
        userRepository.removeAll();
    }

    @Test
    public void getRecentPostsFromFollowed() throws Exception {
        User user1 = new User(1L, "Lucas", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2L, "Marcos", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        Post post1 = new Post(1L, user2, LocalDate.now(),new Product(), 1,10);
        Post post2 = new Post(2L, user2, LocalDate.now().minusDays(2),new Product(),100, 20000);
        Post post3 = new Post(3L, user2, LocalDate.now().minusDays(4),new Product(),100, 20000);
        Post post4 = new Post(4L, user2, LocalDate.now().minusDays(6),new Product(),100, 20000);

        user2.addPost(post1);
        user2.addPost(post2);
        user2.addPost(post3);
        user2.addPost(post4);
        user1.follow(user2);

        userRepository.add(user1);
        userRepository.add(user2);

        mockMvc.perform(get("/products/followed/1/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].user_id").value(2L))
                .andExpect(jsonPath("$[0].posts[0].price").value(10));

    }
}

package com.meli.be_java_hisp_w18_g01.integration;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    private User lucas;
    private User miguel;
    private User laura;
    private User agustin;

    Post post1;
    Post post2;
    Post post3;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initUsers(){
        lucas = new User(1L, "lucas");
        miguel = new User(2L, "miguel");
        laura = new User(3L, "laura");
        agustin = new User(4L, "agustin");

        Product product1 = new Product(1L, "Zapatillas", "Tipo de zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        post1 = new Post(1L, lucas, LocalDate.now(),product1,100, 20000);
        post2 = new Post(2L, lucas, LocalDate.of(2022,11,11),product1,100, 20000);
        post3 = new Post(3L, lucas, LocalDate.of(2022,10,11),product1,100, 20000);
    }

    @BeforeEach
    public void clean(){
        userRepository.removeAll();
    }

    @Test
    @DisplayName("Seguir a un usuario")
    public void followUser() throws Exception {
        //Arrange
        userRepository.add(lucas);
        userRepository.add(miguel);
        miguel.addPost(post1);
        //Act - Assert
        mockMvc.perform(post("/users/1/follow/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Dejar de seguir a un usuario")
    public void unfollowUser() throws Exception {
        //Arrange
        userRepository.add(lucas);
        userRepository.add(miguel);
        miguel.addPost(post1);
        lucas.follow(miguel);
        //Act - Assert
        mockMvc.perform(post("/users/1/unfollow/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtener cantidad de seguidores de un usuario")
    public void getFollowersCount() throws Exception {
        //Arrange
        userRepository.add(lucas);
        userRepository.add(miguel);
        miguel.addPost(post1);
        lucas.follow(miguel);
        //Act - Assert
        mockMvc.perform(get("/users/2/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(1));
    }

    @Test
    @DisplayName("Obtener información de los seguidores de un usuario")
    public void getFollowersInfo() throws Exception {
        //Arrange
        userRepository.add(lucas);
        userRepository.add(miguel);
        miguel.addPost(post1);
        lucas.follow(miguel);
        //Act - Assert
        mockMvc.perform(get("/users/2/followers/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers.length()").value(1))
                .andExpect(jsonPath("$.followers[0].user_id").value(1L));
    }

    @Test
    @DisplayName("Obtener información de los seguidos de un usuario")
    public void getFollowedInfo() throws Exception {
        //Arrange
        userRepository.add(lucas);
        userRepository.add(miguel);
        miguel.addPost(post1);
        lucas.follow(miguel);
        //Act - Assert
        mockMvc.perform(get("/users/1/followed/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed.length()").value(1))
                .andExpect(jsonPath("$.followed[0].user_id").value(2L));
    }
}

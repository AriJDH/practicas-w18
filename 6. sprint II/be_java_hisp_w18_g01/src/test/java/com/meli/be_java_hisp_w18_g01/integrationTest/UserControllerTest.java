package com.meli.be_java_hisp_w18_g01.integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void load() {
        userRepository.removeAll();
    }

    @Test
    public void countFollwers() throws  Exception {

        //Arrange
        UserFollowersCountDTO userFollowersCountDTO =
                new UserFollowersCountDTO(
                        1L,
                        "lucas",
                        1
                );

        ProductDTO productDTO = new ProductDTO(
                1L,
                "Zapatillas",
                "zapatilla",
                "Adadis",
                "Blancas",
                "Las mejores"
        );

        PostDTO postDTO = new PostDTO(
                1L,
                "30-11-2022",
                productDTO,
                100,
                20000.0
        );

        User lucas = new User(1L, "lucas");
        userRepository.add(lucas);

        User miguel = new User(2L, "miguel");
        userRepository.add(miguel);

        //Mapper
        String stringUserFollowersCountDTO =
                this.objectMapper.writeValueAsString(userFollowersCountDTO);
        String content = this.objectMapper.writeValueAsString(postDTO);

        //ResultMatcher
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(stringUserFollowersCountDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        this.mockMvc.perform(post("/users/2/follow/1")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        this.mockMvc.perform(get("/users/1/followers/count")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(resultMatcher)
                .andReturn();

    }

    @Test
    public void followersList() throws Exception {

        //Arrange
        UserDTO userDTO = new UserDTO(
                2L,
                "miguel"
        );

        ProductDTO productDTO = new ProductDTO(
                1L,
                "Zapatillas",
                "zapatilla",
                "Adadis",
                "Blancas",
                "Las mejores"
        );

        PostDTO postDTO = new PostDTO(
                1L,
                "30-11-2022",
                productDTO,
                100,
                20000.0
        );

        List<UserDTO> usersDTO = new ArrayList<>();
        usersDTO.add(userDTO);

        UserFollowersInfoDTO userFollowersInfoDTO =
                new UserFollowersInfoDTO(
                        1L,
                        "lucas",
                        usersDTO
                );

        User lucas = new User(1L, "lucas");
        userRepository.add(lucas);

        User miguel = new User(2L, "miguel");
        userRepository.add(miguel);

        //Mapper
        String stringUserFollowers = this.objectMapper.writeValueAsString(userFollowersInfoDTO);
        String content = this.objectMapper.writeValueAsString(postDTO);

        //ResultMatcher
        ResultMatcher resultMatcher =
                MockMvcResultMatchers.content()
                        .json(stringUserFollowers);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        this.mockMvc.perform(post("/users/2/follow/1")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        this.mockMvc.perform(get("/users/1/followers/list")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(resultMatcher)
                .andReturn();
    }

    @Test
    public void unfollowed() throws Exception {

        //Arrange
        ResponseDTO responseDTO = new ResponseDTO(404, "El usuario 7 no existe.");

        //Mapper
        String stringResponseDTO = this.objectMapper.writeValueAsString(responseDTO);

        //ResultMatcher
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(stringResponseDTO);

        //Act and Assert
        this.mockMvc.perform(post("/users/7/unfollow/1")
                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(resultMatcher)
                .andReturn();
    }

}

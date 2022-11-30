package com.sprint1.be_java_hisp_w18_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.UserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.UserDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.service.IUserService;
import com.sprint1.be_java_hisp_w18_g03.service.UserServiceImp;

import static com.sprint1.be_java_hisp_w18_g03.utils.UserFactory.*;
import static com.sprint1.be_java_hisp_w18_g03.utils.PostFactory.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AutoConfigureMockMvc
@SpringBootTest
public class UserTestShould {

    @Autowired
    MockMvc mockMvc;

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @Mock
    UserServiceImp userServiceImp;

    @BeforeEach
    void setUp() {
        List<User> users = new ArrayList<>(
                Arrays.asList(
                        new User(1, "Gabriela", new ArrayList<>(), new ArrayList<>()),
                        new User(2, "Dizzi", new ArrayList<>(), new ArrayList<>()),
                        new User(3, "Juan_Pablo", new ArrayList<>(), new ArrayList<>()),
                        new User(4, "Julian", new ArrayList<>(), new ArrayList<>()),
                        new User(5, "Jhonier", new ArrayList<>(), new ArrayList<>()),
                        new User(6, "Angel", new ArrayList<>(), new ArrayList<>())
                )
        );
        when(userRepository.selectAll()).thenReturn(users);
    }

    @Test
    @DisplayName("T-0007 Verificar la cantidad seguidores de un usuario sea correcta. (US-0002)")
    void check_number_of_followers() throws Exception {

        //Arrange

        User user = userRepository.selectAll().get(5);

        String responseJson = new ObjectMapper().writeValueAsString(new FollowerCountDTO(
                user.getUserId(),
                user.getUserName(),
                user.getListFollowers().size()));

        //Matchers
        ResultMatcher expectedStatus = status().is(200);
        ResultMatcher expectedJson = content().json(responseJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = get("/users/{userId}/followers/count", user.getUserId()).contentType(MediaType.APPLICATION_JSON).content(responseJson);

        //Act y assert
        mockMvc.perform(requestPayload).andDo(print()).andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }


    @Order(7)
    @Test
    @DisplayName("T-0007 Verificar que el usuario no tiene seguidores. -> Error exeption")
    void check_number_of_followed_empty() throws Exception {

        //Arrange

        User user = userRepository.selectAll().get(0);;

        ResponseDTO response = new ResponseDTO("The user hasn't followers", 400);
        String responseJson = new ObjectMapper().writeValueAsString(response);


        //Matchers
        ResultMatcher expectedStatus = status().is(400);
        ResultMatcher expectedJson = content().json(responseJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder requestPayload = get("/users/{userId}/followers/list", user.getUserId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);


        //Act y assert
        mockMvc.perform(requestPayload).andDo(print()).
                andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }
}

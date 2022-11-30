package com.meli.be_java_hisp_w18_g9.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.util.UsersFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class UserIntegration {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserRepository userRepository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    @DisplayName("Follow a seller")
    void followASeller () throws Exception
    {
        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Juan",true, false, false);
        User userToFollowMock = UsersFactory.getUserWithAllList(2,"Andrea",true, false, false);

        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.of(userToFollowMock));

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userMock.getUserId(), userToFollowMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(status().isOk());

    }

    @Test
    @DisplayName("Follow an user not seller")
    void followNotAnSeller () throws Exception
    {
        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Juan",true, false, false);
        User userToFollowMock = UsersFactory.getUserWithAllList(2,"Andrea",false, false, false);

        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.of(userToFollowMock));

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userMock.getUserId(), userToFollowMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(status().isForbidden())
                .andExpect(jsonPath("$.message").value("User to follow is not a seller"));

    }

    @Test
    @DisplayName("Follow yourself")
    void followYourself () throws Exception
    {
        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Juan",true, false, false);
        User yourselfMock = userMock;

        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        when(userRepository.findById(yourselfMock.getUserId())).thenReturn(Optional.of(yourselfMock));

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userMock.getUserId(), yourselfMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(status().isForbidden())
                .andExpect(jsonPath("$.message").value("You can't follow yourself"));

    }

    @Test
    @DisplayName("user to Follow don't exists")
    void userToFollowDontExists () throws Exception
    {
        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Juan",true, false, false);
        User userToFollowMock = UsersFactory.getUserWithAllList(2,"Andrea",false, false, false);

        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.empty());

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userMock.getUserId(), userToFollowMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(status().isNotFound())
                .andExpect(jsonPath("$.message").value("user to follow with Id " +userToFollowMock.getUserId()+ " doesn't exist"));

    }

    @Test
    @DisplayName("find All Followed of an user without order")
    void userFollowedList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Messi",true, true, false);

        UserFollowedListResponse userFollowedListResponse = UsersFactory.getUserFollowedListResponse(userMock, 0);
        String userJson = writer.writeValueAsString(userFollowedListResponse);
        System.out.println(userFollowedListResponse);
        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);
    }

    @Test
    @DisplayName("find All Followed of an user with desc order")
    void userFollowedWithOrderDescList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Messi",true, true, false);

        UserFollowedListResponse userFollowedListResponse = UsersFactory.getUserFollowedListResponse(userMock, 1);
        String userJson = writer.writeValueAsString(userFollowedListResponse);
        System.out.println(userFollowedListResponse);
        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);
    }

    @Test
    @DisplayName("find All Followed of an user with asc order")
    void userFollowedWithOrderAscList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Cristiano",true, true, false);

        UserFollowedListResponse userFollowedListResponse = UsersFactory.getUserFollowedListResponse(userMock, 2);
        String userJson = writer.writeValueAsString(userFollowedListResponse);
        System.out.println(userFollowedListResponse);
        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);
    }

    @Test
    @DisplayName("find All Follower of an user without order")
    void userFollowerList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Cristiano",true, false, true);

        UserFollowerListResponse userFollowerListResponse = UsersFactory.getUserFollowerListResponse(userMock,0);
        String userJson = writer.writeValueAsString(userFollowerListResponse);
        System.out.println(userFollowerListResponse);

        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userMock.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);

    }

    @Test
    @DisplayName("find All Follower of an user with order desc")
    void userFollowerWithOrderDescList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Cristiano",true, false, true);

        UserFollowerListResponse userFollowerListResponse = UsersFactory.getUserFollowerListResponse(userMock, 1);
        String userJson = writer.writeValueAsString(userFollowerListResponse);
        System.out.println(userFollowerListResponse);

        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userMock.getUserId())
                .param("order","name_desc")
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);

    }

    @Test
    @DisplayName("find All Follower of an user with asc desc")
    void userFollowerWithOrderAscList () throws Exception{

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(1,"Cristiano",true, false, true);

        UserFollowerListResponse userFollowerListResponse = UsersFactory.getUserFollowerListResponse(userMock, 2);
        String userJson = writer.writeValueAsString(userFollowerListResponse);
        System.out.println(userFollowerListResponse);

        //Mock
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));

        /* Expect Response */
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userMock.getUserId())
                .param("order","name_asc")
                .contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson,expectedContentType);

    }

}

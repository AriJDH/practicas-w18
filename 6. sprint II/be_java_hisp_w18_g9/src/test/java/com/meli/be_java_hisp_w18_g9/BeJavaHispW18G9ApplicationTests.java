package com.meli.be_java_hisp_w18_g9;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.util.UsersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BeJavaHispW18G9ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserRepository userRepository;

    ObjectWriter writer = new ObjectMapper().writer();




    @Test
    @DisplayName("Integration test 01 - FOLLOW")
    void followTest() throws Exception {



        User user1 = UsersFactory.getUserWithAllList(1,"Juan",false, false, false);
        User user3 = UsersFactory.getUserWithAllList(3,"Roberto",true, false, false);


        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        when(userRepository.findById(user3.getUserId())).thenReturn(Optional.of(user3));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", user1.getUserId(), user3.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration test 02 - FOLLOWERS COUNT")
    void followersCountTest() throws Exception{

        User user1 = UsersFactory.getUserWithAllList(1,"Juan",false, false, true);
        FollowersCountUserResponse followersCountUserResponse = UsersFactory.getFollowersCountUserResponse(user1);
        String expectedUserJson = writer.writeValueAsString(followersCountUserResponse);
        String endpoint = "/users/{userId}/followers/count";

        performRequestTest(expectedUserJson,user1,endpoint);
    }

    @Test
    @DisplayName("Integration test 03 - FOLLOWERS LIST")
    void followersListTest() throws Exception{

        User user1 = UsersFactory.getUserWithAllList(1,"Juan",true, false, true);
        UserFollowerListResponse userFollowerListResponse = UsersFactory.getUserFollowersListResponse(user1);
        String expectedUserJson = writer.writeValueAsString(userFollowerListResponse);
        String endpoint = "/users/{userId}/followers/list";

        performRequestTest(expectedUserJson,user1,endpoint);
    }

    @Test
    @DisplayName("Integration test 04 - FOLLOWED LIST")
    void followedListTest() throws Exception{

        User user1 = UsersFactory.getUserWithAllList(1,"Juan",false, true, false);
        UserFollowedListResponse userFollowedListResponse = UsersFactory.getUserFollowedListResponse(user1);
        String expectedUserJson = writer.writeValueAsString(userFollowedListResponse);
        String endpoint = "/users/{userId}/followed/list";

        performRequestTest(expectedUserJson,user1,endpoint);
    }


    void performRequestTest(String expectedUserJson, User user1,String endpoint) throws Exception{

        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(endpoint, user1.getUserId())
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedUserJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

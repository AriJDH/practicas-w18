package com.example.SocialMeli2.integration;

import com.example.SocialMeli2.dto.respose.FollowDTORes;
import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followTest() throws Exception{
        //ARRANGE

        FollowDTORes followDTORes = new FollowDTORes();
        followDTORes.setUserNameFollowed("Ethan");
        followDTORes.setUserName("Josep");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(followDTORes);



        //MATCHERS
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //REQUEST
        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/count",2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResponse);

        mockMvc
                .perform(response)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);


    }

    @Test
    void methodGetFollowedTest() throws Exception {
        FollowedListDTORes followedListDTORes = new FollowedListDTORes();
        followedListDTORes.setUser_id(1);
        followedListDTORes.setUser_name("Josep");
        List<UserDTORes> followed = new ArrayList<>();
        UserDTORes userDTOResA = new UserDTORes(2,"Ethan");
        followed.add(userDTOResA);
        followedListDTORes.setFollowed(followed);
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(followedListDTORes);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder response = MockMvcRequestBuilders
                .get("/users/{client_id}/followed/list",1)
                .param("order","name_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson);

        mockMvc
                .perform(response)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(expectedContentType)
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Josep"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", hasSize(3)));
    }

}

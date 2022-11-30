package com.example.SocialMeli2.integration;

import com.example.SocialMeli2.dto.respose.FollowDTORes;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


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
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
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


}

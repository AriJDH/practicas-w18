package com.dh.be_java_hisp_w18_g10.integration;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.util.UserGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    UserDTOres userDtOres;

    @Test
    void testIntegration() throws Exception {
        //US0004
        /*ARRANGE*/
        //datos que necesito
        UserFollowedListDTOres userFollowed = UserGenerator.userFollowedList();
        String bodyExpected = new ObjectMapper().writeValueAsString(userFollowed);

        /*MATCHERS*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(bodyExpected);

        /*REQUEST*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 1);

        /*ACT & ASSERT*/
        mockMvc.perform(requestPayload)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedResult)
                .andExpect(expectedStatus);
    }
    @Test
    void testIntegrationFollowedOrdeAsc() throws Exception {
        //US0008
        /*ARRANGE*/
        //datos que necesito
        UserFollowedListDTOres userFollowed = UserGenerator.userFollowedList();
        String bodyExpected = new ObjectMapper().writeValueAsString(userFollowed);

        /*MATCHERS*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(bodyExpected);

        /*REQUEST*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list?order=name_asc", 1); ///users/1/followed/list?order=name_asc

        /*ACT & ASSERT*/
        mockMvc.perform(requestPayload)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedResult)
                .andExpect(expectedStatus);
    }

    @Test
    void testIntegrationFollowers() throws Exception {
        //US0003
        /*ARRANGE*/
        //datos que necesito
        UserFollowersListDTOres userFollowers = UserGenerator.userFollowerList();
        String bodyExpected = new ObjectMapper().writeValueAsString(userFollowers);

        /*MATCHERS*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(bodyExpected);

        /*REQUEST*/
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 2);

        /*ACT & ASSERT*/
        mockMvc.perform(requestPayload)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedResult)
                .andExpect(expectedStatus);
    }

}

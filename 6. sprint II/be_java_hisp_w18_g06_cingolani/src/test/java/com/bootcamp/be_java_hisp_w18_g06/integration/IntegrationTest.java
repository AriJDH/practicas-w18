package com.bootcamp.be_java_hisp_w18_g06.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Nested
    class individualSUTFollowUser {

        @Test
        @DisplayName("Verify status 204 - Follow an user OK")
        void verifyStatus200FollowUserOkTest() throws Exception {
            //Arrange
            int userId = 2;
            int userIdToFollow = 1;


            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNoContent();


            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/follow/" + userIdToFollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(expectedStatus);
        }


        @Test
        @DisplayName("Verify status 400 -> Message: 'Can't follow this user because he doesn't have any post'")
        void verifyStatus400CantFollowUserWithoutPostsTest() throws Exception {
            //Arrange
            int userId = 1;
            int userIdToFollow = 2;

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/follow/" + userIdToFollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(content().string("{\"message\":\"You can't follow this user because he doesn't have any posts\"}"))
                    .andExpect(expectedStatus);
        }

        @Test
        @DisplayName("Verify status 400 -> Message: 'You can't follow yourself'")
        void verifyStatus400ExceptionMessageYouCanNotFollowYourSelfTest() throws Exception {
            //Arrange
            int id = 1;
            int userId = id;
            int userIdToFollow = id;

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/follow/" + userIdToFollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(expectedStatus)
                    .andExpect(content().string("{\"message\":\"You can't follow yourself\"}"));

        }

    }
}
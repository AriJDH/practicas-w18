package com.bootcamp.be_java_hisp_w18_g06.integration;


import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.UserService;
import org.junit.jupiter.api.Assertions;
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

import java.util.Arrays;

import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserWithFollowedList;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository repository;

    @Autowired
    UserService userService;


    @Nested
    class individualSUTFollowUser {

        @Test
        @DisplayName("Verify status 204 - Follow an user OK")
        void verifyStatus200FollowUserOkTest() throws Exception {
            //Arrange
            int userId = 2;
            int userIdToFollow = 1;

            User follower = getUserWithFollowedList("Follower");
            follower.setUser_id(userId);

            User followed = repository.findUserById(userIdToFollow).get();
            int expectedNumberOfFollowersFromUserFollowed = followed.getFollowers().size();  //seller

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


            Assertions.assertEquals(expectedNumberOfFollowersFromUserFollowed,
                    repository.findUserById(userIdToFollow).get().getFollowers().size());

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
                    .andExpect(content().json("{\"message\":\"You can't follow yourself\"}"));

        }


        @Test
        @DisplayName("Verify status 400 -> Message: 'This user doesn't exists'")
        void verifyStatus400ExceptionMessageThisUserDoesNotExitsOktest() throws Exception {
            //Arrange
            int id = 1;
            int userId = id;
            int userIdToFollow = 3;

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
                    .andExpect(content().json("{\"message\":\"This user doesn't exist\"}"));

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
                    .andExpect(content().json("{\"message\":\"You can't follow this user because he doesn't have any posts\"}"))
                    .andExpect(expectedStatus);
        }
    }


    @Nested
    class individualSUTUnfollowUser {

        @Test
        @DisplayName("Verify status 200 - unfollow  user OK")
        void verifyStatus200UnfollowUserOkTest() throws Exception {
            //Arrange
            int userId = 2;
            int userIdToUnfollow = 1;

            User follower = repository.findUserById(userId).get();
            User followed = repository.findUserById(userIdToUnfollow).get();

            follower.setFollowed(Arrays.asList(repository.findUserById(userIdToUnfollow).get()));
            followed.setFollowers(Arrays.asList(repository.findUserById(userId).get()));

            userService.unfollowUser(userId, userIdToUnfollow);

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNoContent();


            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/unfollow/" + userIdToUnfollow);



            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(expectedStatus);
        }

        @Test
        @DisplayName("Verify status 400 -> Message: 'You can't unfollow yourself'")
        void verifyStatus400ExceptionMessageYouCanNotUnFollowYourSelfTest() throws Exception {
            //Arrange
            int id = 1;
            int userId = id;
            int userIdToUnfollow = id;

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/unfollow/" + userIdToUnfollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(expectedStatus)
                    .andExpect(content().string("{\"message\":\"You can't unfollow yourself\"}"));

        }


        @Test
        @DisplayName("Verify status 400 -> Message: 'This user doesn't exists'")
        void verifyStatus400ExceptionMessageThisUserDoesNotExitsOktest() throws Exception {
            //Arrange
            int id = 3;
            int userId = id;
            int userIdToUnfollow = 4;

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/unfollow/" + userIdToUnfollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(expectedStatus)
                    .andExpect(content().json("{\"message\":\"User doesn't exist\"}"));

        }


        @Test
        @DisplayName("Verify status 400 -> Message: 'The users don't follow each other'")
        void verifyStatus400CantFollowUserWithoutPostsTest() throws Exception {
            //Arrange
            int userId = 1;
            int userIdToUnfollow = 2;

            /*Matchers*/
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

            /*Request*/
            MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                    .post("/users/" + userId + "/unfollow/" + userIdToUnfollow);

            /*Act & Assert*/
            mockMvc
                    .perform(post)
                    .andDo(print())
                    .andExpect(content().json("{\"message\":\"The users don't follow each other\"}"))
                    .andExpect(expectedStatus);
        }


    }
}
package com.bootcamp.be_java_hisp_w18_g06.integration;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository.getUsers;
import static com.bootcamp.be_java_hisp_w18_g06.utils.PostFactory.getPost;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Nested
    class followUserTests{
        @Test
        void followUserOkTest() throws Exception {
            List<User>users=getUsers();
            User seller=users.get(0);
            User buyer=users.get(1);

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",buyer.getUser_id(),seller.getUser_id()))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }

    @Nested
    class unFollowUserTest{
        @Test
        void unfollowUserOkTest() throws Exception {
            List<User>users=getUsers();
            User seller=users.get(0);
            seller.setPosts(Collections.singletonList(getPost(seller.getUser_id())));
            User buyer=users.get(1);
            buyer.setFollowed(Collections.singletonList(seller));
            seller.setFollowers(Collections.singletonList(buyer));

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",buyer.getUser_id(),seller.getUser_id()))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }

    @Nested
    class getFollowersCountTests{
        @Test
        void getFollowersCountOkTest() throws Exception {
            List<User>users=getUsers();
            User seller=users.get(0);
            User buyer=users.get(1);
            seller.setFollowers(Collections.singletonList(buyer));

            UserFollowersCountDTO expectDto=new UserFollowersCountDTO();
            expectDto.setUser_id(seller.getUser_id());
            expectDto.setUser_name(seller.getUser_name());
            expectDto.setFollowers_count(1);


            String expectJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(expectDto);

           MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",seller.getUser_id()))
                    .andDo(print())
                    .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
           assertEquals(expectJson,result.getResponse().getContentAsString());
        }
    }
    /*
    getFollowedList
     */
    @Nested
    class getFollowedListTests{
        @Test
        void getFollowedListOkTest() throws Exception {
            List<User>users=getUsers();
            User seller=users.get(0);
            User buyer=users.get(1);
            seller.setFollowed(Collections.singletonList(buyer));
            //buyer.setFollowed(Collections.singletonList(seller));


            UserFollowedListDTO expectUsers=new UserFollowedListDTO();
            UserFollowDTO userFollowDTO=new UserFollowDTO();
            userFollowDTO.setUser_id(buyer.getUser_id());
            userFollowDTO.setUser_name(buyer.getUser_name());
            expectUsers.setUser_id(seller.getUser_id());
            expectUsers.setUser_name(seller.getUser_name());
            expectUsers.setFollowed(Collections.singletonList(userFollowDTO));


            String expectJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(expectUsers);

            MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",seller.getUser_id()))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andReturn();
            assertEquals(expectJson,result.getResponse().getContentAsString());
        }

    }

    @Nested
    class getFollowersListTests{
        @Test
        void getFollowersListOkTest() throws Exception {
            List<User>users=getUsers();
            User seller=users.get(0);
            User buyer=users.get(1);
            seller.setFollowers(Collections.singletonList(buyer));


            UserFollowersListDTO expectUsers=new UserFollowersListDTO();
            UserFollowDTO userFollowDTO=new UserFollowDTO();
            userFollowDTO.setUser_id(buyer.getUser_id());
            userFollowDTO.setUser_name(buyer.getUser_name());
            expectUsers.setUser_id(seller.getUser_id());
            expectUsers.setUser_name(seller.getUser_name());
            expectUsers.setFollowers(Collections.singletonList(userFollowDTO));


            String expectJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(expectUsers);

            MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",seller.getUser_id()))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andReturn();
            assertEquals(expectJson,result.getResponse().getContentAsString());
        }

    }


}
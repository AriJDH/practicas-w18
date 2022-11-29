package com.meli.be_java_hisp_w18_g9_camacho_ovalle.integration;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersIntegrationTest {

    // ? ================= Attributes ================= ?

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserRepository userRepository;

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("Get all users followed by a user - Without filter order")
    void getAllUsersFollowedByUserWithoutFilterOrder() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest = new User(2, "Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest)));
        sellerTest.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user_id").value(1))
            .andExpect(jsonPath("$.user_name").value("User test 1"))
            .andExpect(jsonPath("$.followed", hasSize(1)))
            .andExpect(jsonPath("$.followed[0].user_id").value(2))
            .andExpect(jsonPath("$.followed[0].user_name").value("Seller test 1"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followed by a user - User not found")
    void getAllUsersFollowedByUserNotFound() throws Exception {

        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("user doesn't exist"))
                .andReturn();


    }

    // * ============= *

    @Test
    @DisplayName("Get all users followed by a user - User without followed")
    void getAllUsersFollowedByUserWithoutFollowed() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followed", hasSize(0)));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followed by a user - order by name asc filter")
    void getAllUsersFollowedByUserOrderByNameAsc() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest1 = new User(2, "A: Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest2 = new User(3, "B: Seller test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest1, sellerTest2)));
        sellerTest1.setFollowers(new ArrayList<>(List.of(userTest)));
        sellerTest2.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(2))
                .andExpect(jsonPath("$.followed[0].user_name").value("A: Seller test 1"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("B: Seller test 2"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followed by a user - order by name desc filter")
    void getAllUsersFollowedByUserOrderByNameDesc() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest1 = new User(2, "A: Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest2 = new User(3, "B: Seller test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest1, sellerTest2)));
        sellerTest1.setFollowers(new ArrayList<>(List.of(userTest)));
        sellerTest2.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followed", hasSize(2)))
                .andExpect(jsonPath("$.followed[0].user_id").value(3))
                .andExpect(jsonPath("$.followed[0].user_name").value("B: Seller test 2"))
                .andExpect(jsonPath("$.followed[1].user_id").value(2))
                .andExpect(jsonPath("$.followed[1].user_name").value("A: Seller test 1"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followed by a user - invalid order filter")
    void getAllUsersFollowedByUserInvalidOrder() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest1 = new User(2, "A: Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest2 = new User(3, "B: Seller test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest1, sellerTest2)));
        sellerTest1.setFollowers(new ArrayList<>(List.of(userTest)));
        sellerTest2.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1)
                        .param("order", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("invalid parameters"));

    }

    // * ============= *

    @Test
    @DisplayName("Get count of followers of a user")
    void getCountOfFollowersOfUser() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followers_count").value(2));

    }

    // * ============= *

    @Test
    @DisplayName("Get count of followers of a user - user not found")
    void getCountOfFollowersOfUserNotFound() throws Exception {

        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id:1 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Get count of followers of a user - invalid user id")
    void getCountOfFollowersOfUserInvalidId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

    }

    // * ============= *

    @Test
    @DisplayName("Get count of followers of a user - followers list empty")
    void getCountOfFollowersOfUserEmptyList() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followers_count").value(0));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - Without filter order")
    void getAllUsersFollowersByUserWithoutOrder() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));
        User followerTest1 = new User(2, "A: Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "B: Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followers[0].user_id").value(2))
                .andExpect(jsonPath("$.followers[0].user_name").value("A: Follower test 1"))
                .andExpect(jsonPath("$.followers[1].user_id").value(3))
                .andExpect(jsonPath("$.followers[1].user_name").value("B: Follower test 2"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - order by name asc filter")
    void getAllUsersFollowersByUserOrderByNameAsc() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));
        User followerTest1 = new User(2, "A: Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "B: Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followers[0].user_id").value(2))
                .andExpect(jsonPath("$.followers[0].user_name").value("A: Follower test 1"))
                .andExpect(jsonPath("$.followers[1].user_id").value(3))
                .andExpect(jsonPath("$.followers[1].user_name").value("B: Follower test 2"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - order by name desc filter")
    void getAllUsersFollowersByUserOrderByNameDesc() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));
        User followerTest1 = new User(2, "A: Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "B: Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("User test 1"))
                .andExpect(jsonPath("$.followers[0].user_id").value(3))
                .andExpect(jsonPath("$.followers[0].user_name").value("B: Follower test 2"))
                .andExpect(jsonPath("$.followers[1].user_id").value(2))
                .andExpect(jsonPath("$.followers[1].user_name").value("A: Follower test 1"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - invalid order filter")
    void getAllUsersFollowersByUserInvalidOrder() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));
        User followerTest1 = new User(2, "A: Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "B: Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1)
                        .param("order", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("invalid parameters"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - user not found")
    void getAllUsersFollowersByUserNotFound() throws Exception {

        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id 1 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - invalid user id")
    void getAllUsersFollowersByUserInvalidUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    // * ============= *

    @Test
    @DisplayName("Get all users followers by a user - Non-seller user")
    void getAllUsersFollowersByUserNonSeller() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "A: Follower test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest2 = new User(3, "B: Follower test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowers(new ArrayList<>(List.of(followerTest1, followerTest2)));
        followerTest1.setFollowed(new ArrayList<>(List.of(userTest)));
        followerTest2.setFollowed(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("User with id 1 is not a seller"));

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user")
    void followUser() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(followerTest1));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - already following")
    void followUserAlreadyFollowing() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));

        userTest.setFollowed(new ArrayList<>(List.of(followerTest1)));
        followerTest1.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(followerTest1));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("You already follow the user with Id 2"));

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - user to follow not found")
    void followUserNotFound() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("user to follow with Id 2 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - user follower not found")
    void followUserFollowerNotFound() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        when(userRepository.findById(2)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with 1 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - invalid user id")
    void followUserInvalidUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", "invalid", 2))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - invalid user to follow id")
    void followUserInvalidUserToFollowId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - follow yourself")
    void followUserFollowYourself() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("You can't follow yourself"));

    }

    // * ============= *

    @Test
    @DisplayName("Follow a user - Non-seller user")
    void followUserNonSellerUser() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(followerTest1));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("User to follow is not a seller"));

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user")
    void unfollowUser() throws Exception {

        Product productTest1 = new Product();

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), List.of(productTest1));

        userTest.setFollowed(new ArrayList<>(List.of(followerTest1)));
        followerTest1.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(followerTest1));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - user to unfollow not found")
    void unfollowUserNotFound() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("user to follow with Id 2 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - user follower not found")
    void unfollowUserFollowerNotFound() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        when(userRepository.findById(2)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with 1 doesn't exist"));

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - invalid user id")
    void unfollowUserInvalidUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", "invalid", 2))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - invalid user to unfollow id")
    void unfollowUserInvalidUserToUnfollowId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - unfollow yourself")
    void unfollowUserUnfollowYourself() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("You can't unfollow yourself"));

    }

    // * ============= *

    @Test
    @DisplayName("Unfollow a user - User not followed")
    void unfollowUserNotFollowed() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followerTest1 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(followerTest1));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("You don't follow the user with id: 2"));

    }

}

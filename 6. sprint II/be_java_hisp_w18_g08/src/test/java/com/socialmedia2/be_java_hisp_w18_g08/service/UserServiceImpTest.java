package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImpTest {

    //Revisar si realmente hacen falta los dos repos
    @Mock
    UserRepositoryImp userRepo;
    @Mock
    PostRepositoryImp postRepo;

    @InjectMocks
    UserServiceImp userService;
    @InjectMocks
    PostServiceImp postService;

   @Test
   @DisplayName("T-0001 Usuario a seguir existe")
    void testFollowUserIdExist() {

        // Arrange
        List<Seller> followed = new ArrayList<>();
        List<User> followers = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        User user = new User(1, "User1", followed);
        Seller seller = new Seller(5, "User5", followed, posts, followers);
        Seller seller2 = new Seller(6, "User6", followed, posts, followers);
        followed.add(seller2);

        String message = user.getUser_name() + " with id: " + user.getUser_id() + " is following -> " + seller.getUser_name() + " with id: "+ seller.getUser_id();
        FollowDtoReq followDtoReq = new FollowDtoReq(1, 5);
        FollowDtoRes expected = new FollowDtoRes(200, message);

        when(userRepo.getUserByID(followDtoReq.getUserId())).thenReturn(user);
        when(userRepo.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow())).thenReturn(message);

        // Act
        FollowDtoRes result = userService.follow(followDtoReq);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("T-0001 Usuario a seguir no existe")
    void testFollowUserIdNoExist() {

        //Arrange
        List<Seller> followed = new ArrayList<>();
        User user = new User(1, "User1", followed);
        FollowDtoReq followDtoReq = new FollowDtoReq(user.getUser_id(), 10);
        //Act
        //Assert
        assertThrows(NotFoundUserException.class,()->userService.follow(followDtoReq));

    }

    @Test
    void getFollowed() {
    }

    @Test
    void findAllFollowersQuantity() {
    }

    @Test
    void findUserListBySeller() {
    }

    @Test
    void getFollowedByUserId() {
    }

    @Test
    void unFollow() {
    }
}
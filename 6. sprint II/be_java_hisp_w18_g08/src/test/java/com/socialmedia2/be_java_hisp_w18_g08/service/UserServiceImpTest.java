package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
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
    void follow() {
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
    @DisplayName("(US-0007), Cumple :) Verificar que el usuario a dejar de seguir exista.")
    void unFollowCumple() {
        //Arrange

        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        List<Post> post5 = new ArrayList<>();

        Seller s1 = new Seller(5, "User5", followed, post5, followers);
        User u1 = new User(1, "User1", followed);

        followers.add(u1);
        followed.add(s1);

        String expected = u1.getUser_name() + "with id:"+ u1.getUser_id() + " unfollow to -> " + s1.getUser_name() + " with id: "+ s1.getUser_id();;

        when(userRepo.unFollow(u1.getUser_id(),s1.getUser_id())).thenReturn(expected);

        //Act

        String result = userService.unFollow(u1.getUser_id(),s1.getUser_id());

        //Assert

        assertEquals(expected,result);



    }

    @Test
    @DisplayName("(US-0007), NoCumple :( - Verificar que el usuario a dejar de seguir exista. ")
    void unFollowNoCumple() {
        //Arrange
        List<Seller> followed = new ArrayList<>();
        User u1 = new User(1, "User1", followed);

        when(userRepo.unFollow(u1.getUser_id(), 3)).thenThrow(NotFoundUserException.class);

        //Act
        //Assert
        assertThrows(NotFoundUserException.class,()->userService.unFollow(u1.getUser_id(),3));



    }
}
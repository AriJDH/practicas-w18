package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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
    @DisplayName("T-0004 Get followed order by name ascending")
    void getFollowedOrderAsc() {
        Integer id = 5;
        String name = "test";
        String order = "name_asc";

        List<User> followers = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();

        Seller n1 = new Seller(1, "Juan", followed, posts, followers);
        Seller n2 = new Seller(2, "Pedro", followed, posts, followers);
        Seller n3 = new Seller(3, "Andres", followed, posts, followers);
        List<Seller> listUser = Arrays.asList(n1, n2, n3);
        User user = new User(id, name, listUser);

        UserDto u1 = new UserDto(3, "Andres");
        UserDto u2 = new UserDto(1, "Juan");
        UserDto u3 = new UserDto(2, "Pedro");
        List<UserDto> listDto = Arrays.asList(u1, u2, u3);
        FollowedDto expectedRes = new FollowedDto(id, name, listDto);

        when(userRepo.getUserByID(id)).thenReturn(user);

        FollowedDto response = userService.getFollowed(id, order);

        System.out.println("expected:" + expectedRes.getFollowed());
        System.out.println("Response:" + response.getFollowed());


        Assertions.assertEquals(expectedRes.getFollowed(), response.getFollowed());
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
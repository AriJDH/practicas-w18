package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserListDto;
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
        //Arrange
        String order = "name_asc";
        User user = getUser("user");
        Integer id = user.getUser_id();
        UserDto u1 = new UserDto(3, "Andres");
        UserDto u2 = new UserDto(1, "Juan");
        UserDto u3 = new UserDto(2, "Pedro");
        List<UserDto> listTest = Arrays.asList(u1, u2, u3);
        FollowedDto expectedRes = new FollowedDto(id, user.getUser_name(), listTest);
        //Mock
        when(userRepo.getUserByID(id)).thenReturn(user);
        //Act
        FollowedDto response = userService.getFollowed(id, order);
        //Assertion
        Assertions.assertEquals(expectedRes.getFollowed(), response.getFollowed());
    }

    @Test
    @DisplayName("T-0004 Get followed order by name descending")
    void getFollowedOrderDesc() {
        //Arrange
        String order = "name_desc";
        User user = getUser("user");
        Integer id = user.getUser_id();
        UserDto u1 = new UserDto(3, "Andres");
        UserDto u3 = new UserDto(2, "Pedro");
        UserDto u2 = new UserDto(1, "Juan");
        List<UserDto> listTest = Arrays.asList(u3, u2, u1);
        FollowedDto expectedRes = new FollowedDto(id, user.getUser_name(), listTest);
        //Mock
        when(userRepo.getUserByID(id)).thenReturn(user);
        //Act
        FollowedDto response = userService.getFollowed(id, order);
        //Assertion
        Assertions.assertEquals(expectedRes.getFollowed(), response.getFollowed());
    }

    @Test
    @DisplayName("US0004 - Get followers order by name ascending")
    void findUserListBySellerOrderAsc() {
        //Arrange
        String order = "name_asc";
        Seller seller = getSeller("seller");
        Integer id = seller.getUser_id();
        UserDto user1 = new UserDto(1, "Augusto");
        UserDto user2 = new UserDto(3, "Martin");
        UserDto user3 = new UserDto(5, "Samuel");
        List<UserDto> followers = List.of(user1, user2, user3);
        UserListDto expectedRes = new UserListDto(id, seller.getUser_name(), followers);
        //Mock
        when(userRepo.findSellerById(id)).thenReturn(seller);
        //Act
        UserListDto response = userService.findUserListBySeller(id, order);
        //Assertion
        Assertions.assertEquals(expectedRes.getFollowers(), response.getFollowers());
    }

    @Test
    @DisplayName("US0004 - Get followers order by name descending")
    void findUserListBySellerOrderDesc() {
        //Arrange
        String order = "name_desc";
        Seller seller = getSeller("seller");
        Integer id = seller.getUser_id();
        UserDto user1 = new UserDto(1, "Augusto");
        UserDto user2 = new UserDto(3, "Martin");
        UserDto user3 = new UserDto(5, "Samuel");
        List<UserDto> followers = List.of(user3, user2, user1);
        UserListDto expectedRes = new UserListDto(id, seller.getUser_name(), followers);
        //Mock
        when(userRepo.findSellerById(id)).thenReturn(seller);
        //Act
        UserListDto response = userService.findUserListBySeller(id, order);
        //Assertion
        Assertions.assertEquals(expectedRes.getFollowers(), response.getFollowers());
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

    private User getUser(String type) {
        String name = "FakeName";
        Seller n1 = new Seller(1, "Juan", null, null, null);
        Seller n2 = new Seller(2, "Pedro", null, null, null);
        Seller n3 = new Seller(3, "Andres", null, null, null);
        List<Seller> listSellers = Arrays.asList(n1, n2, n3);
        User user = new User(5, name, listSellers);
        return user;
    }

    private Seller getSeller(String type) {
        User user2 = new User(3, "Martin", null);
        User user1 = new User(1, "Augusto", null);
        User user3 = new User(5, "Samuel", null);
        List<User> followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);
        return seller;
    }

}
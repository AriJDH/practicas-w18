package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserListDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
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
import static org.junit.jupiter.api.Assumptions.*;
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
    @DisplayName("US0003 - List followers order asc")
    void findUserListBySellerOrderAsc(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        User user1 = new User(1, "Augusto", null);
        User user2 = new User(3, "Martin", null);
        User user3 = new User(5, "Samuel", null);
        List<User> followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);

        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);

        //Act
        UserListDto userListDto = userService.findUserListBySeller(userId, order);
        List<UserDto> followersDto = userListDto.getFollowers();

        //Assertion
        assertEquals(user1.getUser_name(), followersDto.get(0).getUser_name());

    }

    @Test
    @DisplayName("US0003 - List followers order desc")
    void findUserListBySellerOrderDesc(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        User user1 = new User(1, "Augusto", null);
        User user2 = new User(3, "Martin", null);
        User user3 = new User(5, "Samuel", null);
        List<User> followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);

        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);

        //Act
        UserListDto userListDto = userService.findUserListBySeller(userId, order);
        List<UserDto> followersDto = userListDto.getFollowers();

        //Assertion
        assertEquals(user3.getUser_name(), followersDto.get(0).getUser_name());

    }

    @Test
    void getFollowedByUserId() {
    }

    @Test
    void unFollow() {
    }
}
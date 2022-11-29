package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserListDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.BadRequestException;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    void findAllFollowersQuantity() {
    }

    @ParameterizedTest
    @CsvSource({"name_asc", "name_desc"})
    @DisplayName("T0003 - Verify that the order exists for the list of followers")
    void findUserListBySellerWhitOrderTest(String order){
        //Arrange
        Integer userId = 1;
        User user1 = new User(1, "Augusto", null);
        User user2 = new User(3, "Martin", null);
        User user3 = new User(5, "Samuel", null);
        List<User> followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);

        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);

        //Act
        UserListDto userListDto = userService.findUserListBySeller(userId, order);

        //Assertion
        assertNotNull(userListDto);

    }
    @Test
    @DisplayName("T0003 - Invalid parameter error in findUserListBySeller method")
    void findUserListBySellerInvalidParameterTest(){
        //Arrange
        Integer userId = 1;
        String order = "name";
        User user1 = new User(1, "Augusto", null);
        User user2 = new User(3, "Martin", null);
        User user3 = new User(5, "Samuel", null);
        List<User> followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);

        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);

        //Act
        //Assertion
        assertThrows(BadRequestException.class,
                () -> userService.findUserListBySeller(userId, order));

    }
    @ParameterizedTest
    @CsvSource({"name_asc", "name_desc"})
    @DisplayName("T0003 - Verify that the order exists for the list of followed")
    void getFollowedWhitOrderTest(String order){
        //Arrange
        Integer userId = 1;
        Seller seller1 = new Seller(1, "Augusto", null, null, null);
        Seller seller2 = new Seller(3, "Martin", null,null,null);
        Seller seller3 = new Seller(5, "Samuel", null, null, null);
        List<Seller> followed = List.of(seller1, seller2, seller3);
        User user = new User(1, "Seller1", followed);

        //Mock
        when(userRepo.getUserByID(userId)).thenReturn(user);

        //Act
        FollowedDto followedDto = userService.getFollowed(userId, order);

        //Assertion
        assertNotNull(followedDto);

    }
    @Test
    @DisplayName("T0003 - Invalid parameter error in getFollowed method")
    void getFollowedInvalidParameterTest(){
        //Arrange
        Integer userId = 1;
        String order = "name";
        Seller seller1 = new Seller(1, "Augusto", null, null, null);
        Seller seller2 = new Seller(3, "Martin", null,null,null);
        Seller seller3 = new Seller(5, "Samuel", null, null, null);
        List<Seller> followed = List.of(seller1, seller2, seller3);
        User user = new User(1, "Seller1", followed);

        //Mock
        when(userRepo.getUserByID(userId)).thenReturn(user);

        //Act
        //Assertion
        assertThrows(BadRequestException.class,
                () -> userService.getFollowed(userId, order));

    }

    @Test
    void getFollowedByUserId() {
    }

    @Test
    void unFollow() {
    }
}
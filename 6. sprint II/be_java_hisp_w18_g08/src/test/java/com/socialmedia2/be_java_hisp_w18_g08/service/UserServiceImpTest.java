package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserListDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.BadRequestException;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
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
    void findAllFollowersQuantity() {
    }

    @ParameterizedTest
    @CsvSource({"name_asc", "name_desc"})
    @DisplayName("T-0003 - Verify that the order exists for the list of followers")
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
    @DisplayName("T-0003 - Invalid parameter error in findUserListBySeller method")
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
    @DisplayName("T-0003 - Verify that the order exists for the list of followed")
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
    @DisplayName("T-0003 - Invalid parameter error in getFollowed method")
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
    @DisplayName("(T-0007), Cumple :) Verificar que el usuario a dejar de seguir exista.")
    void unFollowCumple() {
        //Arrange

        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        List<Post> post5 = new ArrayList<>();

        Seller s1 = new Seller(5, "User5", followed, post5, followers);
        //Seller s2 = new Seller(6, "User6", followed, post6, followers);

        User u1 = new User(1, "User1", followed);
        //User u2 = new User(2, "User2", followed);

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
    @DisplayName("(T-0007), NoCumple :( - Verificar que el usuario a dejar de seguir exista. ")
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
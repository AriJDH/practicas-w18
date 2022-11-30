package com.socialmedia2.be_java_hisp_w18_g08.unitTest.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserListDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.BadRequestException;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.SellerFollowersCountDto;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.service.UserServiceImp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImpTest {

    @Mock
    UserRepositoryImp userRepo;
    @InjectMocks
    UserServiceImp userService;

    User user1;
    User user2;
    User user3;
    Seller seller1;
    Seller seller2;
    Seller seller3;
    List<Seller> followed = new ArrayList<>();
    List<User> followers = new ArrayList<>();
    List<Post> postList = new ArrayList<>();

    @BeforeEach
    private void setup(){

        user1 = new User(1, "Augusto", followed);
        user2 = new User(3, "Martin", null);
        user3 = new User(5, "Samuel", null);
        seller1 = new Seller(1, "Augusto", followed, postList, followers);
        seller2 = new Seller(3, "Martin", followed, postList, followers);
        seller3 = new Seller(5, "Samuel", followed, postList, followers);

    }

    @Order(1)
    @Test
    @DisplayName("T-0001 - Usuario a seguir existe")
    void testFollowUserIdExist() {
        // Arrange

        followed.add(seller2);
        String message =
                user1.getUser_name() + " with id: " + user1.getUser_id() + " is following -> " + seller1.getUser_name() +
                        " with id: " + seller1.getUser_id();
        FollowDtoReq followDtoReq = new FollowDtoReq(1, 5);
        FollowDtoRes expected = new FollowDtoRes(200, message);

        when(userRepo.getUserByID(followDtoReq.getUserId())).thenReturn(user1);
        when(userRepo.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow())).thenReturn(message);

        // Act
        FollowDtoRes result = userService.follow(followDtoReq);

        // Assert
        assertEquals(expected, result);

    }

    @Order(2)
    @Test
    @DisplayName("T-0001 - Usuario a seguir no existe")
    void testFollowUserIdNoExist() {
        //Arrange

        FollowDtoReq followDtoReq = new FollowDtoReq(user1.getUser_id(), 10);
        //Act
        //Assert
        assertThrows(NotFoundUserException.class, () -> userService.follow(followDtoReq));

    }

    @Order(5)
    @ParameterizedTest
    @CsvSource({"name_asc", "name_desc"})
    @DisplayName("T-0003 - Verificar que el orden para la lista que retorna el metodo findUserListBySellerWhitOrder exista")
    void findUserListBySellerWhitOrderTest(String order) {
        //Arrange
        Integer userId = 1;
        followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);

        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);

        //Act
        UserListDto userListDto = userService.findUserListBySeller(userId, order);

        //Assertion
        assertNotNull(userListDto);

    }

    @Order(6)
    @Test
    @DisplayName("T-0003 - Error por parametro invalido en el metodo findUserListBySeller")
    void findUserListBySellerInvalidParameterTest() {
        //Arrange
        Integer userId = 1;
        String order = "name";

        followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);
        //Mock
        when(userRepo.findSellerById(userId)).thenReturn(seller);
        //Assertion
        assertThrows(BadRequestException.class, () -> userService.findUserListBySeller(userId, order));

    }

    @Order(7)
    @ParameterizedTest
    @CsvSource({"name_asc", "name_desc"})
    @DisplayName("T-0003 - Verificar que el orden para la lista que retorna el metodo getFollowed exista")
    void getFollowedWhitOrderTest(String order) {
        //Arrange
        Integer userId = 1;

        followed = List.of(seller1, seller2, seller3);
        User user = new User(1, "Seller1", followed);
        //Mock
        when(userRepo.getUserByID(userId)).thenReturn(user);
        //Act
        FollowedDto followedDto = userService.getFollowed(userId, order);
        //Assertion
        assertNotNull(followedDto);
    }

    @Order(8)
    @Test
    @DisplayName("T-0003 - error por parametro invaldo en el metodo getFollowed")
    void getFollowedInvalidParameterTest() {
        //Arrange
        Integer userId = 1;
        String order = "name";

        followed = List.of(seller1, seller2, seller3);
        User user = new User(1, "Seller1", followed);
        //Mock
        when(userRepo.getUserByID(userId)).thenReturn(user);
        //Assertion
        assertThrows(BadRequestException.class, () -> userService.getFollowed(userId, order));

    }

    @Order(13)
    @Test
    @DisplayName("T-0007 - Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)")
    void findAllFollowersQuantityTest() {
        //Arrange
        Integer expected = 2;
        Integer id = 5;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("12-11-2022", formatter);

        List<Seller> sellers = new ArrayList<>();
        followers.add(user1);
        followers.add(user2);
        followed.add(seller1);
        sellers.add(seller1);

        when(userRepo.findSellerById(id)).thenReturn(seller3);
        //Act
        SellerFollowersCountDto result = userService.findAllFollowersQuantity(id);


        //Assert
        Assertions.assertEquals(expected, result.getFollowers_count());
    }

    @Order(9)
    @Test
    @DisplayName("T-0004 - Obtener vendedores seguidos ordenados de manera ascendente")
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

    @Order(10)
    @Test
    @DisplayName("T-0004 - Obtener vendedores seguidos ordenados de manera descendente")
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

    @Order(11)
    @Test
    @DisplayName("T-0004 - Obtener seguidores ordenados de manera ascendente")
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

    @Order(12)
    @Test
    @DisplayName("T-0004 - Obtener seguidores ordenados de manera descendente")
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

    @Order(3)
    @Test
    @DisplayName("T-0002 - Cumple :) Verificar que el usuario a dejar de seguir exista.")
    void unFollowCumple() {
        //Arrange


        followers.add(user1);
        followed.add(seller1);

        String expected = user1.getUser_name() + "with id:" + user1.getUser_id() + " unfollow to -> " + seller1.getUser_name() +
                " with id: " + seller1.getUser_id();
        ;

        when(userRepo.unFollow(user1.getUser_id(), seller1.getUser_id())).thenReturn(expected);

        //Act

        String result = userService.unFollow(user1.getUser_id(), seller1.getUser_id());

        //Assert

        assertEquals(expected, result);


    }

    @Order(4)
    @Test
    @DisplayName("T-0002 - NoCumple :( - Verificar que el usuario a dejar de seguir exista. ")
    void unFollowNoCumple() {
        //Arrange
        when(userRepo.unFollow(user1.getUser_id(), 3)).thenThrow(NotFoundUserException.class);

        //Act
        //Assert
        assertThrows(NotFoundUserException.class, () -> userService.unFollow(user1.getUser_id(), 3));


    }

    private User getUser(String type) {
        String name = "FakeName";
        Seller n1 = new Seller(1, "Juan", null, null, null);
        Seller n2 = new Seller(2, "Pedro", null, null, null);
        Seller n3 = new Seller(3, "Andres", null, null, null);
        followed = Arrays.asList(n1, n2, n3);
        User user = new User(5, name, followed);
        return user;
    }

    private Seller getSeller(String type) {
        User user2 = new User(3, "Martin", null);
        User user1 = new User(1, "Augusto", null);
        User user3 = new User(5, "Samuel", null);
        followers = List.of(user1, user2, user3);
        Seller seller = new Seller(1, "Seller1", null, null, followers);
        return seller;
    }

}
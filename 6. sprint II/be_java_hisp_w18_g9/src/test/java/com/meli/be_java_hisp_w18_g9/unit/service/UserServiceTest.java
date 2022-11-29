package com.meli.be_java_hisp_w18_g9.unit.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import com.meli.be_java_hisp_w18_g9.util.UsersFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class UserServiceTest {

    // ? ================= Attributes ================= ?

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("[T001] - Verify that the user exists (Happy path)")
    void follow() {
        // arrange
        User userMock = UsersFactory.getUserById(4, "Messi", false);
        User userToFollowMock = UsersFactory.getUserById(5, "Cristiano", true);
        Mockito.when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        Mockito.when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.of(userToFollowMock));

        // act
        HttpStatus followMockResponse = userService.follow(userMock.getUserId(), userToFollowMock.getUserId());

        // assert
        verify(userRepository, atLeastOnce()).update(userMock);
        assertEquals(HttpStatus.OK, followMockResponse);

    }

    // * ============== *

    @Test
    @DisplayName("[T001] - Verify that the user exists (Sad Path)")
    void followSadPath() {
        // arrange
        User userMock = UsersFactory.getUserById(1, "Messi", false);
        User userToFollowMock = UsersFactory.getUserById(2, "Cristiano", true);
        Mockito.when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        Mockito.when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.empty());

        // act & assert
        assertThrows(NotFoundException.class, () -> userService.follow(userMock.getUserId(),userToFollowMock.getUserId()));

    }

    // * ============= *

    @Test
    @DisplayName("[T002] - Verify that the user to unfollow exists. (Happy path)")
    void unfollow() {
        // ARRANGE
        User userTarget = User.builder()
                .userId(1)
                .userName("Ariel")
                .build();

        User userFollower = User.builder()
                .userId(2)
                .userName("Janeth")
                .build();

        List<User> userTargetFollowers = new ArrayList<>(List.of(userFollower));
        List<User> userFollowerFollowers = new ArrayList<>(List.of(userTarget));

        userTarget.setFollowers(userTargetFollowers);
        userTarget.setFollowed(userTargetFollowers);

        userFollower.setFollowers(userFollowerFollowers);
        userFollower.setFollowed(userFollowerFollowers);


        //ACT
        when(userRepository.findById(userTarget.getUserId())).thenReturn(
                Optional.of(userTarget)); // main user validation
        when(userRepository.findById(userFollower.getUserId())).thenReturn(
                Optional.of(userFollower)); // user validation to follow
        HttpStatus unfollowResult =
                userService.unfollow(userTarget.getUserId(), userFollower.getUserId());
        //ASSERT
        assertEquals(HttpStatus.OK, unfollowResult);

    }

    // * ============= *

    @Test
    @DisplayName("[T002] - Verify that the user to unfollow exists. Notifies non-existence by means of an exception")
    void unfollowBad() {
        // ARRANGE
        User userTarget = User.builder()
                .userId(1)
                .userName("Ariel")
                .build();

        //ACT
        when(userRepository.findById(userTarget.getUserId())).thenReturn(
                Optional.of(userTarget)); // main user validation
        when(userRepository.findById(2)).thenReturn(
                Optional.empty()); // user validation to follow
        // ASSERT
        NotFoundException Exception = assertThrows(NotFoundException.class,
                () ->  userService.unfollow(userTarget.getUserId(), 2));
        assertEquals("user to follow with Id 2 doesn't exist", Exception.getMessage());

    }

    // * ============= *

    @Test
    @DisplayName("List followers")
    void findAllFollowed() {

        // Arrange
        User userMock = UsersFactory.getUserWithAllList(4,"Michael", true, true, false);
        UserFollowedListResponse expected = UsersFactory.getUserFollowedListResponse(userMock);

        //Act
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        UserFollowedListResponse userFollowedResponse =
                userService.findAllFollowed(userMock.getUserId());

        //ASSERT
        assertAll(() ->{
            assertNotNull(userFollowedResponse);
            assertTrue(userFollowedResponse.getFollowed().size()>0);
        });
    }


    // * ============= *

    @Test
    @DisplayName("[T007] - Verify that the number of followers of a certain user is correct. ")
    void findUserFollowerQuantity() {

        // ARRANGE
        User userTarget = User.builder()
                .userId(1)
                .userName("Ariel")
                .build();

        User userFollower1 = User.builder()
                .userId(2)
                .userName("Janeth")
                .build();
        User userFollower2 = User.builder()
                .userId(3)
                .userName("Angel")
                .build();
        User userFollower3 = User.builder()
                .userId(4)
                .userName("Valentina")
                .build();
        Product product1 = Product.builder()
                .productId(1)
                .productName("Notebook Mac")
                .type("Notebook")
                .brand("Apple")
                .color("Gray")
                .notes("Excelent!")
                .build();
        Product product2 = Product.builder()
                .productId(2)
                .productName("Notebook Asus")
                .type("Notebook")
                .brand("Asus")
                .color("White")
                .notes("Excelent!")
                .build();
        List<User> userTargetFollowers = new ArrayList<>(List.of(userFollower1, userFollower2, userFollower3));
        List<Product> userTargetProducts = new ArrayList<>(List.of(product1, product2));
        userTarget.setFollowers(userTargetFollowers);
        userTarget.setProducts(userTargetProducts);

        // ACT
        when(userRepository.findById(userTarget.getUserId())).thenReturn(Optional.of(userTarget));
        UserFollowerListResponse userFollowerListResponse =
                userService.findAllFollower(userTarget.getUserId());

        // ASSERT
        assertEquals(userTargetFollowers.size(), userFollowerListResponse.getFollowers().size());
    }

    // * ============= *

    @Test
    @DisplayName("[T004] - Verify correct ascending order of followed.")
    void findAllFollowedOrderAsc() {

        //--------------------- Arrange ------------------------------------------------------

        //------ Create user for test
        User userTest1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest3 = new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest4 = new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // ------ Create products
        Product productTest1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product productTest2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");
        Product productTest3 = new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!");

        // ------ Create list products
        List<Product> listProducTest = new ArrayList<>();

        // ------ Add product to list
        listProducTest.add(productTest1);
        listProducTest.add(productTest2);
        listProducTest.add(productTest3);

        //------ Create
        List <User> listUsersFollowed = new ArrayList<>();

        // ------ Add user to the list

        listUsersFollowed.add(userTest2);
        listUsersFollowed.add(userTest3);
        listUsersFollowed.add(userTest4);



        //---- Insert followed and products
        userTest1.setFollowed(listUsersFollowed);
        userTest1.setProducts(listProducTest);

        //------ Create list for order user
        List <User> listSorterExpect = new ArrayList<>(listUsersFollowed);
        listSorterExpect.sort(Comparator.comparing(User::getUserName));



        // ----------------------------------------------------- Act -----------------------------------------------------

        when (userRepository.findById(userTest1.getUserId())).thenReturn(Optional.of(userTest1));

        UserFollowedListResponse resultUserFollowedLisTest = userService.findAllFollowedOrderAsc(userTest1.getUserId());

        // ----------------------------------------------------- Assert -----------------------------------------------------
        assertAll(() ->{
            assertEquals(listSorterExpect.get(0).getUserName(),resultUserFollowedLisTest.getFollowed().get(0).getUserName());
            assertEquals(listSorterExpect.get(1).getUserName(),resultUserFollowedLisTest.getFollowed().get(1).getUserName());
            assertEquals(listSorterExpect.get(2).getUserName(),resultUserFollowedLisTest.getFollowed().get(2).getUserName());
        });


    }

    // * ============= *

    @Test
    @DisplayName("[T004] - Verify correct ascending order of follower.")
    void findAllFollowerOrderAsc(){

        //--------------------- Arrange ------------------------------------------------------

        //------ Create user for test
        User userTest1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest3 = new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest4 = new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // ------ Create products
        Product productTest1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product productTest2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");
        Product productTest3 = new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!");

        // ------ Create list products
        List<Product> listProducTest = new ArrayList<>();

        // ------ Add product to list
        listProducTest.add(productTest1);
        listProducTest.add(productTest2);
        listProducTest.add(productTest3);

        //------ Create
        List <User> listUsersFollower = new ArrayList<>();

        // ------ Add user to the list

        listUsersFollower.add(userTest2);
        listUsersFollower.add(userTest3);
        listUsersFollower.add(userTest4);



        //---- Insert followed and products
        userTest1.setFollowers(listUsersFollower);
        userTest1.setProducts(listProducTest);

        //------ Create list for order user
        List <User> listSorterExpect = new ArrayList<>(listUsersFollower);
        listSorterExpect.sort(Comparator.comparing(User::getUserName));



        // ----------------------------------------------------- Act -----------------------------------------------------

        when (userRepository.findById(userTest1.getUserId())).thenReturn(Optional.of(userTest1));

        UserFollowerListResponse resultUserFollowerLisTest = userService.findAllFollowerOrderAsc(userTest1.getUserId());

        // ----------------------------------------------------- Assert -----------------------------------------------------

        assertAll(() ->{
            assertEquals(listSorterExpect.get(0).getUserName(),resultUserFollowerLisTest.getFollowers().get(0).getUserName());
            assertEquals(listSorterExpect.get(1).getUserName(),resultUserFollowerLisTest.getFollowers().get(1).getUserName());
            assertEquals(listSorterExpect.get(2).getUserName(),resultUserFollowerLisTest.getFollowers().get(2).getUserName());
        });

    }

    // * ============= *

    @Test
    @DisplayName("[T004] - Verify correct descending order of follower.")
    void findAllFollowerOrderDesc() {

        //--------------------- Arrange ------------------------------------------------------

        //------ Create user for test
        User userTest1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest3 = new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest4 = new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // ------ Create products
        Product productTest1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product productTest2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");
        Product productTest3 = new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!");

        // ------ Create list products
        List<Product> listProducTest = new ArrayList<>();

        // ------ Add product to list
        listProducTest.add(productTest1);
        listProducTest.add(productTest2);
        listProducTest.add(productTest3);

        //------ Create
        List <User> listUsersFollower = new ArrayList<>();

        // ------ Add user to the list

        listUsersFollower.add(userTest2);
        listUsersFollower.add(userTest3);
        listUsersFollower.add(userTest4);



        //---- Insert followed and products
        userTest1.setFollowers(listUsersFollower);
        userTest1.setProducts(listProducTest);

        //------ Create list for order user
        List <User> listSorterExpect = new ArrayList<>(listUsersFollower);
        listSorterExpect.sort(Comparator.comparing(User::getUserName).reversed());



        // ----------------------------------------------------- Act -----------------------------------------------------

        when (userRepository.findById(userTest1.getUserId())).thenReturn(Optional.of(userTest1));

        UserFollowerListResponse resultUserFollowerLisTest = userService.findAllFollowerOrderDesc(userTest1.getUserId());

        // ----------------------------------------------------- Assert -----------------------------------------------------

        assertAll(()-> {
            assertEquals(listSorterExpect.get(0).getUserName(),resultUserFollowerLisTest.getFollowers().get(0).getUserName());
            assertEquals(listSorterExpect.get(1).getUserName(),resultUserFollowerLisTest.getFollowers().get(1).getUserName());
            assertEquals(listSorterExpect.get(2).getUserName(),resultUserFollowerLisTest.getFollowers().get(2).getUserName());
        });


    }

    // * ============= *

    @Test
    @DisplayName("[T004] - Verify correct descending order of followed.")
    void findAllFollowedOrderDesc() {

        //--------------------- Arrange ------------------------------------------------------

        //------ Create user for test
        User userTest1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest3 = new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userTest4 = new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // ------ Create products
        Product productTest1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product productTest2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");
        Product productTest3 = new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!");

        // ------ Create list products
        List<Product> listProducTest = new ArrayList<>();

        // ------ Add product to list
        listProducTest.add(productTest1);
        listProducTest.add(productTest2);
        listProducTest.add(productTest3);

        //------ Create
        List <User> listUsersFollowed = new ArrayList<>();

        // ------ Add user to the list

        listUsersFollowed.add(userTest2);
        listUsersFollowed.add(userTest3);
        listUsersFollowed.add(userTest4);



        //---- Insert followed and products
        userTest1.setFollowed(listUsersFollowed);
        userTest1.setProducts(listProducTest);

        //------ Create list for order user
        List <User> listSorterExpect = new ArrayList<>(listUsersFollowed);
        listSorterExpect.sort(Comparator.comparing(User::getUserName).reversed());



        // ----------------------------------------------------- Act -----------------------------------------------------

        when (userRepository.findById(userTest1.getUserId())).thenReturn(Optional.of(userTest1));

        UserFollowedListResponse resultUserFollowedLisTest = userService.findAllFollowedOrderDesc(userTest1.getUserId());

        // ----------------------------------------------------- Assert -----------------------------------------------------
        assertAll(() -> {
            assertEquals(listSorterExpect.get(0).getUserName(),resultUserFollowedLisTest.getFollowed().get(0).getUserName());
            assertEquals(listSorterExpect.get(1).getUserName(),resultUserFollowedLisTest.getFollowed().get(1).getUserName());
            assertEquals(listSorterExpect.get(2).getUserName(),resultUserFollowedLisTest.getFollowed().get(2).getUserName());
        });

    }

    // * ============= *

    @Test
    @DisplayName("List all users with followers")
    void findAllFollower() {
        // Arrange
        User userMock = UsersFactory.getUserWithAllList(4,"Michael", true, false, true);

        //Act
        when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        UserFollowerListResponse userFollowerListResponse =
                userService.findAllFollower(userMock.getUserId());

        //ASSERT
        assertAll(() -> {
            assertNotNull(userFollowerListResponse);
            assertTrue(userFollowerListResponse.getFollowers().size()>0);
        });

    }

    // * ============= *
}
package com.meli.be_java_hisp_w18_g9.unit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import com.meli.be_java_hisp_w18_g9.util.UsersFactory;
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
    private ObjectMapper mapper;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("Verify that the user exists T-0001 Happy path")
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

    @Test
    @DisplayName("Verify that the user exists T-0001 Sab Path")
    void followSadPath() {
        // arrange
        User userMock = UsersFactory.getUserById(1, "Messi", false);
        User userToFollowMock = UsersFactory.getUserById(2, "Cristiano", true);
        Mockito.when(userRepository.findById(userMock.getUserId())).thenReturn(Optional.of(userMock));
        Mockito.when(userRepository.findById(userToFollowMock.getUserId())).thenReturn(Optional.empty());

        // act & assert
        assertThrows(BadRequestException.class, () -> userService.follow(userMock.getUserId(),userToFollowMock.getUserId()));

    }

    // * ============= *

    @Test
    @DisplayName("T-0002 Verify that the user to unfollow exists. Happy path ")
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
    @DisplayName("T-0002 Verify that the user to unfollow exists. Notifies non-existence by means of an exception ")
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
        BadRequestException Exception = assertThrows(BadRequestException.class,
                () ->  userService.unfollow(userTarget.getUserId(), 2));
        assertEquals("user to follow with Id 2 doesn't exist", Exception.getMessage());
    }

    // * ============= *
    @Test
    void findAllFollowed() {
    }

    // * ============= *

    @Test
    @DisplayName("T-0007 Verify that the number of followers of a certain user is correct. ")
    void findUserFollowedQuantity() {
        // ARRANGE
        User userTarget = User.builder()
                .userId(1)
                .userName("Ariel")
                .build();

        User userFollowed1 = User.builder()
                .userId(2)
                .userName("Janeth")
                .build();
        User userFollowed2 = User.builder()
                .userId(3)
                .userName("Angel")
                .build();
        User userFollowed3 = User.builder()
                .userId(4)
                .userName("Valentina")
                .build();
        List<User> userTargetFolloweds = new ArrayList<>(List.of(userFollowed1, userFollowed2, userFollowed3));
        userTarget.setFollowed(userTargetFolloweds);

        // ACT
        when(userRepository.findById(userTarget.getUserId())).thenReturn(Optional.of(userTarget));
        UserFollowedListResponse userFollowedQuantityTestResult =
                userService.findAllFollowed(userTarget.getUserId());

        // ASSERT
        assertEquals(userTargetFolloweds.size(), userFollowedQuantityTestResult.getFollowed().size());
    }

    // * ============= *

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente por nombre.")
    void findAllFollowedOrderAsc() {

    }

    // * ============= *

    @Test
    void findAllFollowerOrderAsc(){

    }

    // * ============= *

    @Test
    void findAllFollowerOrderDesc() {
    }

    // * ============= *

    @Test
    void findAllFollowedOrderDesc() {
    }

    // * ============= *

    @Test
    void findAllFollower() {
    }

    // * ============= *
}
package com.meli.be_java_hisp_w18_g9.unit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.util.UsersFactory;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

        // act & assert
        assertThrows(BadRequestException.class, () -> userService.follow(userMock.getUserId(),0));

    }

    // * ============= *

    @Test
    void unfollow() {
    }

    // * ============= *

    @Test
    void findAllFollowed() {
    }

    // * ============= *

    @Test
    void findUserFollowedQuantity() {
    }

    // * ============= *

    @Test
    void findAllFollowedOrderAsc() {
    }

    // * ============= *

    @Test
    void findAllFollowerOrderAsc() {
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
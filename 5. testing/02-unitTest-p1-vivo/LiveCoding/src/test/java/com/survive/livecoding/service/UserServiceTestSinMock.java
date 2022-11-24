package com.survive.livecoding.service;

import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
@SpringBootTest
public class UserServiceTestSinMock {

    @Autowired
    IUserService userService;

    @Test
    @DisplayName("US0001 - Camino feliz :D")
    void getAllOkTest() {
        // arrange
        List<UserDto> userListExpected = new ArrayList<>();
        userListExpected.add(new UserDto("Frutas", "Fulano", 24));
        userListExpected.add(new UserDto("Verduras", "Mengano", 18));
        userListExpected.add(new UserDto("Carnes", "Mumino", 73));

        // act
        List<UserDto> userDtoListResult = userService.getAll();

        // assert
        Assertions.assertEquals(userListExpected, userDtoListResult);

    }

}

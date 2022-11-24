package com.survive.livecoding.service;

import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;
import com.survive.livecoding.exception.NotFoundException;
import com.survive.livecoding.repository.UserRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestConMock {

    @Mock
    UserRepositoryImp userRepository;

    @InjectMocks
    UserServiceImp userService;

    @Test
    @DisplayName("US0001 - Camino feliz :D")
    void getAllOkTest() {
        // arrange
        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("Frutas", "Fulano", 24));
        userListMock.add(new User("Verduras", "Mengano", 18));
        userListMock.add(new User("Carnes", "Mumino", 73));


        when(userRepository.getAll()).thenReturn(userListMock);

        List<UserDto> userDtoListExpected = new ArrayList<>();
        userDtoListExpected.add(new UserDto("Frutas", "Fulano", 24));
        userDtoListExpected.add(new UserDto("Verduras", "Mengano", 18));
        userDtoListExpected.add(new UserDto("Carnes", "Mumino", 73));

        // act
        List<UserDto> userDtoListResult = userService.getAll();

        // assert
        Assertions.assertEquals(userDtoListExpected.get(0).getName(), userDtoListResult.get(0).getName());

    }

    @Test
    @DisplayName("US0001 - recibo lista nula")
    void getAllNullListTest() {
        // arrange
        List<User> userListMock = null;

        when(userRepository.getAll()).thenReturn(userListMock);

        // act

        // assert
        Assertions.assertThrows(FileNotFoundException.class, () -> userService.getAll());

    }

    @Test
    @DisplayName("US0002 - camilo feliz :D")
    void getUserByNameTest() {
        // arrange
        Optional<User> userOptionalMock = Optional.of(new User("Jose", "Iusda", 68));
        String name = "Jose";

        // act

        // assert
//        Assertions.assertThrows(FileNotFoundException.class, () -> userService.getAll());

    }

    @Test
    @DisplayName("US0001 - recibo lista nula")
    void getUserByNameNullOptionalTest() {
        // arrange
        Optional<User> emptyObject = Optional.empty();
        String name = "";

        when(userRepository.findUser(name)).thenReturn(emptyObject);

        // act

        // assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.findUser(name));

    }

}

package com.survive.livecoding.service;

import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;
import com.survive.livecoding.repository.UserRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestConMock {

    @Mock
    UserRepositoryImp userRepository;

    @InjectMocks
    UserServiceImp userService;

    @Test
    void contextLoads() {
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

}

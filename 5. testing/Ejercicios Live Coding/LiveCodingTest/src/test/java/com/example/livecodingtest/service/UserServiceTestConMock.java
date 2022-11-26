package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.entity.User;
import com.example.livecodingtest.repository.IUserRepository;
import com.example.livecodingtest.service.IUserService;
import com.example.livecodingtest.service.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTestConMock {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImp userService;

    @Test
    void contextLoads() {
        //arrange
        List<User> listaMock = new ArrayList<>();
        listaMock.add(new User("Jose","Perez", 32));
        listaMock.add(new User("María", "Paz", 25));
        listaMock.add(new User("Emilio", "Gonzales", 30));

        List<UserDto> expected = new ArrayList<>();
        expected.add(new UserDto("Jose","Perez", 32));
        expected.add(new UserDto("María", "Paz", 25));
        expected.add(new UserDto("Emilio", "Gonzales", 30));

        when(userRepository.obtenerTodos()).thenReturn(null);
        //verify(userRepository.obtenerTodos(),atLeast(1));
        //act
        //List<UserDto> result = userService.buscarTodos();
        //assert
        assertThrows(NoClassDefFoundError.class,()-> userService.buscarTodos());
    }
}

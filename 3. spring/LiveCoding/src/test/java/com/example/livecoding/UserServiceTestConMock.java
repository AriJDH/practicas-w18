package com.example.livecoding;

import com.example.livecoding.dto.UserDto;
import com.example.livecoding.entity.User;
import com.example.livecoding.repository.IUserRepository;
import com.example.livecoding.repository.UserRepositoryImp;
import com.example.livecoding.service.IUserService;
import com.example.livecoding.service.UserServiceImp;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTestConMock {
    @Mock
    UserRepositoryImp userRepository;
    @InjectMocks
    UserServiceImp userService;

    @Test
    void contextLoads(){
        //Arrange
        List<User> listaMock = new ArrayList<>();
        listaMock.add(new User("Jose", "Perez", 32));
        listaMock.add(new User("Maria", "Paz", 29));
        listaMock.add(new User("Martin", "Profe", 22));


        List<UserDto> expected = new ArrayList<>();
        expected.add(new UserDto("Jose", "Perez", 32));
        expected.add(new UserDto("Maria", "Paz", 29));
        expected.add(new UserDto("Martin", "Profe", 22));


        when(userRepository.obtenerTodos()).thenReturn(listaMock);

        //Act
        List<UserDto> result = userService.obtenerTodos();
        //Assert
        assertEquals(expected.get(0).getNombre(), result.get(0).getNombre());
    }

}

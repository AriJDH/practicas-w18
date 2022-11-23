package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.entity.User;
import com.example.livecodingtest.exception.NotFoundException;
import com.example.livecodingtest.repository.IUserRepository;
import com.example.livecodingtest.repository.UserRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTestSinMock {

    @Autowired
    IUserService userService;

    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName("US0001-Camino Feliz :D")
    void buscarTodosOkTest() {

        //ARRANGE
        List<UserDto> expected = new ArrayList<>();
        expected.add(new UserDto("Jose","Perez", 32));
        expected.add(new UserDto("María", "Paz", 25));
        expected.add(new UserDto("Emilio", "Gonzales", 30));

        //ACT
        List<UserDto> result = userService.buscarTodos();
        //ASSERT
        assertEquals(expected,result);
    }


    @Test
    @DisplayName("US0002-Camino feliz :D")
    void buscarUnUsuarioPorNombreOKTest(){

        //ARRANGE
        String name= "Jose";
        UserDto expected = new UserDto("Jose","Perez", 32);

        //ACT
        UserDto result = userService.buscarUnUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0003-Crear un nuevo usuario - Camino Feliz :D")
    void crearUsuarioOkTest(){

        //ARRANGE
        UserDto nuevoUserDto =  new UserDto("Jose","Perez", 32);
        int sizeBefore = userRepository.obtenerTodos().size();

        //ACT
        UserDto result = userService.crearUsuario(nuevoUserDto);
        int sizeAfter = userRepository.obtenerTodos().size();

        //ASSERT
        assertTrue(sizeBefore+1 == sizeAfter);
        //assertEquals(sizeBefore+1, sizeAfter);
    }
}

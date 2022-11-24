package com.example.livecodingtest.repository;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImpTest {

    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName("US0004 - Camino Feliz :D")
    void obtenerTodosOkTest() {

    }

    @Test
    @DisplayName("US0005 - Camino Feliz :D")
    void guardarUsuarioOkTest() {

        //ARRANGE
        User user = new User("Jose","Perez", 32);
        User expected = new User("Jose","Perez", 32);

        //ACT
        int originalSize = userRepository.obtenerTodos().size();
        User result = userRepository.guardarUsuario(user);
        int resultSize = userRepository.obtenerTodos().size();

        //ASSERT
        assertEquals(expected, result);
        // un poco innecesario lo que sigue...
        assertEquals(originalSize + 1, resultSize);
        assertEquals(expected.getNombre(), userRepository.buscarUsuarioPorNombre(expected.getNombre()).orElseThrow().getNombre());
    }

    @Test
    @DisplayName("US0006 - Camino Feliz :D")
    void buscarUsuarioPorNombreOkTest() {

        //ARRANGE
        String name = "Jose";
        User expected = new User("Jose","Perez", 32);

        //ACT
        User result = userRepository.buscarUsuarioPorNombre(name).orElseThrow();

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0007 - Camino Null :0")
    void buscarUsuarioPorNombreNullTest() {

        //ARRANGE
        String name = null;
        Optional<User> expected = Optional.empty();

        //ACT
        Optional<User> result = userRepository.buscarUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0008 - Camino Empty :|")
    void buscarUsuarioPorNombreEmptyTest() {

        //ARRANGE
        String name = "";
        Optional<User> expected = Optional.empty();

        //ACT
        Optional<User> result = userRepository.buscarUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }
}
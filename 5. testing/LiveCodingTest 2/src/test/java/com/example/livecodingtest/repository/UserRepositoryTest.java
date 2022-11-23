package com.example.livecodingtest.repository;

import com.example.livecodingtest.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName("US0001-Camino Feliz :D")
    void obtenerTodos() {
        //ARRANGE
        List<User> expected = new ArrayList<>();
        expected.add(new User("Jose","Perez", 32));
        expected.add(new User("María", "Paz", 25));
        expected.add(new User("Emilio", "Gonzales", 30));

        //ACT
        List<User> result = userRepository.obtenerTodos();
        //ASSERT
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("US0002-Camino feliz :D")
    void buscarUsuarioPorNombre() {
        //ARRANGE
        String name= "Jose";
        Optional <User> expected = Optional.of(new User("Jose","Perez", 32));

        //ACT
        Optional<User> result = userRepository.buscarUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0003-Camino feliz :D")
    void guardarUsuario() {

        //ARRANGE
        User user = new User("name1","apellido1",33);
        /* User user2 = new User("name2","apellido2",22);
        User user3 = new User("name3","apellido3",44);
        User user4 = new User("name4","apellido4",55);*/
        //Arrays.asList({user, user2, user3});
        User expected = user;

        //ACT
        User result = userRepository.guardarUsuario(user);

        //ASSERT
        assertEquals(expected, result);


    }
}
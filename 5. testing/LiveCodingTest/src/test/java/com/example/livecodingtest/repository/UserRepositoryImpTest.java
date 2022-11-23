package com.example.livecodingtest.repository;

import com.example.livecodingtest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImpTest {

    @Autowired
    private IUserRepository iUserRepository;

    @Test
    void obtenerTodos() {
       List<User> users = iUserRepository.obtenerTodos();

       assertFalse(users.isEmpty(), "La lista no debe estar vacia");

       assertEquals(users.size(), 3, "La lista debe contener 3 elementos");
    }

    @Test
    void guardarUsuario() {

        User user = new User();
        user.setNombre("PRUEBA");
        user.setApellido("PRUEBA APELLIDO");
        user.setEdad(22);

        User userCreado = iUserRepository.guardarUsuario(user);

        assertNotNull(userCreado, "El user no debe ser nulo");

        assertEquals(userCreado.getNombre(), "PRUEBA", "El nombre del usuario debe ser PRUEBA");

        List<User> users = iUserRepository.obtenerTodos();

        assertTrue(users.contains(userCreado));
    }

    @Test
    void buscarUsuarioPorNombre() {

        Optional<User> user = iUserRepository.buscarUsuarioPorNombre("Jose");

        assertNotNull(user, "El usuario no debe ser nulo");

        assertEquals(user.get().getNombre(), "Jose", "El usuario debe tener el nombre Jose");
    }
}
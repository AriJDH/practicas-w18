package com.test.democodingtest;

import com.test.democodingtest.dto.UserDto;
import com.test.democodingtest.entity.User;
import com.test.democodingtest.exception.NotFoundException;
import com.test.democodingtest.repository.IUserRepository;
import com.test.democodingtest.service.UserServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTestConMock {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImp userService;

    @Test
    @DisplayName("US0001-Camino Feliz :D")
    void buscarTodosOkTest() {
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
        List<UserDto> result = userService.buscarTodos();
        //assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("US0001-Recibe Lista Nula")
    void buscarTodosListaNulaTest() {
        //arrange
        List<User> listaMock = null;

        when(userRepository.obtenerTodos()).thenReturn(listaMock);

        //act
        //assert
        assertThrows(NotFoundException.class,()->userService.buscarTodos());
    }

    @Test
    @DisplayName("US0002-Camino feliz :D")
    void buscarUnUsuarioPorNombreOKTest(){

        //ARRANGE
        String name= "Jose";
        Optional<User> joseObject = Optional.of(new User("Jose","Perez", 32));
        UserDto expected = new UserDto("Jose","Perez", 32);

        when(userRepository.buscarUsuarioPorNombre(name)).thenReturn(joseObject);

        //ACT
        UserDto result = userService.buscarUnUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0002-Recibe Optional nulo o vacio")
    void buscarUnUsuarioPorNombreOptNuloTest(){
        String name = "FAKENAME";

        Optional<User> emptyObject = Optional.empty();

        when(userRepository.buscarUsuarioPorNombre(name)).thenReturn(emptyObject);

        assertThrows(NotFoundException.class,()->userService.buscarUnUsuarioPorNombre(name));
    }
    @Test
    @DisplayName("US003 - Guarda un usuario camino feliz")
    void guardarUsuarioOkTest(){
        //ARRANGE
        User user = new User("Mayra", "Torres", 24);
        UserDto userDto = new UserDto("Mayra","Torres",24);
        when(userRepository.guardarUsuario(user)).thenReturn(user);

        //ACT
        UserDto userDtoResult = userService.crearUsuario(userDto);

        //ASSERT
        assertEquals(userDto, userDtoResult);
//        assertTrue(userDto.getNombre().equals(userDtoResult.getNombre()));
    }

}

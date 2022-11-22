package meli.bootcamp.testunitariovivo01;

import meli.bootcamp.testunitariovivo01.dto.UserDto;
import meli.bootcamp.testunitariovivo01.entity.User;
import meli.bootcamp.testunitariovivo01.repository.UserRepository;
import meli.bootcamp.testunitariovivo01.service.UserService;
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
//@SpringBootTest
public class UserServiceTest
{
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void contextLoad()
    {
        //
        List<User> listaMock = new ArrayList<>();
        listaMock.add(new User("aaaaaa", "bbbbbb", 11));
        listaMock.add(new User("cccccc", "dddddd", 22));
        listaMock.add(new User("eeeeee", "ffffff", 33));
        listaMock.add(new User("gggggg", "hhhhhh", 44));
        listaMock.add(new User("iiiiii", "jjjjjj", 55));

        List<UserDto> expectedUserDtoList = new ArrayList<>();
        expectedUserDtoList.add(new UserDto("aaaaaa", "bbbbbb", 11));
        expectedUserDtoList.add(new UserDto("cccccc", "dddddd", 22));
        expectedUserDtoList.add(new UserDto("eeeeee", "ffffff", 33));
        expectedUserDtoList.add(new UserDto("gggggg", "hhhhhh", 44));
        expectedUserDtoList.add(new UserDto("iiiiii", "jjjjjj", 55));
        when(userRepository.obtenerTodos()).thenReturn(listaMock);
        //
        List<UserDto> result = userService.obtenerTodos();
        //
        Assertions.assertEquals(expectedUserDtoList.get(0).getNombre(), result.get(0).getNombre());

    }
}

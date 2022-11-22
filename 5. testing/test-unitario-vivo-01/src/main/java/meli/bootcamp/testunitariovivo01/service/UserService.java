package meli.bootcamp.testunitariovivo01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.testunitariovivo01.dto.UserDto;
import meli.bootcamp.testunitariovivo01.entity.User;
import meli.bootcamp.testunitariovivo01.repository.IUserRepository;
import meli.bootcamp.testunitariovivo01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService
{

    IUserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto crearUsuario(UserDto userDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(userDto, User.class);
        return objectMapper.convertValue(userRepository.guardarUsuario(user), UserDto.class);
    }

    @Override
    public List<UserDto> obtenerTodos() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = userRepository.obtenerTodos();
        return userList.stream()
                .map( x -> objectMapper.convertValue(x, UserDto.class))
                .collect(Collectors.toList());
    }
}

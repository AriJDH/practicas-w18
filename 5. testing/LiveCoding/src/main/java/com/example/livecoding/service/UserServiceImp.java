package com.example.livecoding.service;

import com.example.livecoding.dto.UserDto;
import com.example.livecoding.entity.User;
import com.example.livecoding.repository.IUserRepository;
import com.example.livecoding.repository.UserRepositoryImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> obtenerTodos() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> listaUsuariosRepo = userRepository.obtenerTodos();
        List<UserDto> listaUserReturn = mapper.convertValue(listaUsuariosRepo, new TypeReference<List<UserDto>>() {
        });
        return listaUserReturn;
    }

    @Override
    public UserDto crearUsuario(UserDto userDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(userDto, User.class);
        User userRes = userRepository.guardarUsuario(user);
        UserDto userDtoRes = objectMapper.convertValue(userRes, UserDto.class);
        return userDtoRes;
    }
}

package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.entity.User;
import com.example.livecodingtest.repository.IUserRepository;
import com.example.livecodingtest.repository.UserRepositoryImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.LifecycleListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto crearUsuario(UserDto userDto) {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(userDto, User.class);
        User userRes = userRepository.guardarUsuario(user);
        UserDto userDtoRes = mapper.convertValue(userRes, UserDto.class);

        return userDtoRes;
    }

    @Override
    public List<UserDto> buscarTodos() {
        ObjectMapper mapper = new ObjectMapper();
        List<User>listaUsuariosRepo = userRepository.obtenerTodos();
        if (listaUsuariosRepo != null) {

        }
        List<UserDto> listaUserReturn = mapper.convertValue(listaUsuariosRepo, new TypeReference<List<UserDto>>(){});
        return listaUserReturn;
    }
}

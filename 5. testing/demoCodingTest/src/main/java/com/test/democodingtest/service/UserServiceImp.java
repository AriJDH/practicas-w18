package com.test.democodingtest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.democodingtest.dto.UserDto;
import com.test.democodingtest.entity.User;
import com.test.democodingtest.exception.NotFoundException;
import com.test.democodingtest.repository.IUserRepository;
import com.test.democodingtest.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto crearUsuario(UserDto userDto) {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(userDto,User.class);
        User userRes = userRepository.guardarUsuario(user);
        UserDto userDtoRes = mapper.convertValue(userRes, UserDto.class);
        return userDtoRes;
    }

    @Override
    public List<UserDto> buscarTodos() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> listaUsuariosRepo = userRepository.obtenerTodos();
        if (listaUsuariosRepo == null) {
            throw new NotFoundException("la lista de usuarios esta vacía");
        }
        List<UserDto> listaUserReturn = mapper.convertValue(listaUsuariosRepo, new TypeReference<List<UserDto>>(){});
        return listaUserReturn;
    }
    @Override
    public UserDto buscarUnUsuarioPorNombre(String name) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<User> usuarioRepo = userRepository.buscarUsuarioPorNombre(name);
        Optional<User> usuarioRepo2 = userRepository.buscarUsuarioPorNombre(name);
        if(usuarioRepo.isPresent()){
            User u = usuarioRepo.get();
            UserDto userDto = mapper.convertValue(u,UserDto.class);
            return userDto;
        }
        throw new NotFoundException("El usuario no existe");
    }
}

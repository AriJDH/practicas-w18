package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.entity.User;
import com.example.livecodingtest.exception.NotFoundException;
import com.example.livecodingtest.repository.IUserRepository;
import com.example.livecodingtest.repository.UserRepositoryImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.LifecycleListener;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDto eliminarUsuario(String name) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<User> usuarioEliminado = userRepository.eliminarUsuario(name);
        if(usuarioEliminado.isPresent()){
            User u = usuarioEliminado.get();
            UserDto userDto = mapper.convertValue(u,UserDto.class);
            return userDto;
        }

        throw new NotFoundException("El usuario no existe");
    }

}

package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;

import java.util.List;

public interface IUserService {

    UserDto crearUsuario(UserDto userDto);

    List<UserDto> buscarTodos();

    UserDto buscarUnUsuarioPorNombre(String name);
}

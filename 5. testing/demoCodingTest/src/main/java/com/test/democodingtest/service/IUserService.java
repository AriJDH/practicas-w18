package com.test.democodingtest.service;

import com.test.democodingtest.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto crearUsuario(UserDto userDto);

    List<UserDto> buscarTodos();

    UserDto buscarUnUsuarioPorNombre(String name);
}

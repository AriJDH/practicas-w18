package com.example.livecoding.service;

import com.example.livecoding.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> obtenerTodos();

    UserDto crearUsuario(UserDto userDto);
}

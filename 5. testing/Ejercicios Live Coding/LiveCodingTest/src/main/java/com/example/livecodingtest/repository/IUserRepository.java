package com.example.livecodingtest.repository;

import com.example.livecodingtest.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> obtenerTodos();

    User guardarUsuario(User user);
}

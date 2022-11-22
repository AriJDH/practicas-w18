package com.example.livecoding.repository;

import com.example.livecoding.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> obtenerTodos();

    User guardarUsuario(User user);
}

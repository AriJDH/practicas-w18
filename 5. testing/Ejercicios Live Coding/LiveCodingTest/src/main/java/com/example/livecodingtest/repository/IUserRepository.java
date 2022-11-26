package com.example.livecodingtest.repository;

import com.example.livecodingtest.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> obtenerTodos();

    User guardarUsuario(User user);

    Optional<User> buscarUsuarioPorNombre(String name);
}

package meli.bootcamp.testunitariovivo01.repository;

import meli.bootcamp.testunitariovivo01.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> obtenerTodos();
    User guardarUsuario(User user);
}

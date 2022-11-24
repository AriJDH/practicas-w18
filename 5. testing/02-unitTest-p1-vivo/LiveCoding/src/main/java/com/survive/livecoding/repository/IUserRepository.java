package com.survive.livecoding.repository;

import com.survive.livecoding.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAll();
    List<User> addUser(User user);
    Optional<User> findUser(String userName);
}

package com.survive.livecoding.service;

import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserDto addUser(UserDto userDTO);
    List<UserDto> getAll();
    UserDto findUser(String userName);
}


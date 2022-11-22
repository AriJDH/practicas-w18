package com.survive.livecoding.service;

import com.survive.livecoding.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto addUser(UserDto userDTO);
    List<UserDto> getAll();
}


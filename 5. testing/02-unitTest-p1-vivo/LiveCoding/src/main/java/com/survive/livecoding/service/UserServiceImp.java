package com.survive.livecoding.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;
import com.survive.livecoding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements IUserService{

    private final IUserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(userDTO, User.class);
        userRepository.addUser(user);
        return userDTO;
    }

    @Override
    public List<UserDto> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = userRepository.getAll();
        return objectMapper.convertValue(userList, new TypeReference<List<UserDto>>() {});
    }
}

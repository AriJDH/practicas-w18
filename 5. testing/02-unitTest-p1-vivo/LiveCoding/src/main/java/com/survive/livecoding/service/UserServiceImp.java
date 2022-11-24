package com.survive.livecoding.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survive.livecoding.dto.UserDto;
import com.survive.livecoding.entity.User;
import com.survive.livecoding.exception.NotFoundException;
import com.survive.livecoding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

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
        if (userList == null) {
            throw new NotFoundException("No users");
        }
        return objectMapper.convertValue(userList, new TypeReference<List<UserDto>>() {});
    }

    @Override
    public UserDto findUser(String userName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<User> user = userRepository.findUser(userName);
        if (user.isEmpty()) {
            throw new NotFoundException("No user with that name found");
        }
        return objectMapper.convertValue(user, UserDto.class);
    }


}

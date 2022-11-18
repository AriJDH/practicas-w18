package com.example.socialmeli.repository;

import com.example.socialmeli.entity.UserEntity;

import java.util.Map;

public interface IUserRepository {

    UserEntity getEntityByID(Integer id);

    Map<Integer, UserEntity> getAllEntity();

    void followSeller(Integer userId, Integer userIdToFollow);
    boolean isSeller(Integer userIdToFollow);
    boolean exist(Integer userId);
}

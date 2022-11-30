package com.example.socialmeli2.repository;

import com.example.socialmeli2.entity.UserEntity;

import java.util.Map;

public interface IUserRepository {

    void followSeller(Integer userId, Integer userIdToFollow);

    void unfollowSeller(Integer userId, Integer userIdToUnfollow);

    Boolean exist(Integer userId);

    Boolean isSeller(Integer userId);

    UserEntity getEntityById(Integer userId);

    Map<Integer, UserEntity> getAllEntity();

}

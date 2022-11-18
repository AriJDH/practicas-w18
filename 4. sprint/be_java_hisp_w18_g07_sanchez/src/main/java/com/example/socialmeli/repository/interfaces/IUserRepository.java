package com.example.socialmeli.repository.interfaces;

import com.example.socialmeli.entity.UserEntity;

import java.util.Map;

public interface IUserRepository {

    void followSeller(Integer userId, Integer userIdToFollow);

    void unfollowSeller(Integer userId, Integer userIdToUnfollow);

    Boolean exist(Integer userId);

    Boolean isSeller(Integer userId);

    UserEntity getEntityById(Integer userId);

    Map<Integer, UserEntity> getAllEntity();

}

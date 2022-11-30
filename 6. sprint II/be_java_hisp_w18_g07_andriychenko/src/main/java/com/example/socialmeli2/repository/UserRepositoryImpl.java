package com.example.socialmeli2.repository;

import com.example.socialmeli2.entity.UserEntity;
import com.example.socialmeli2.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private Map<Integer, UserEntity> users = new HashMap<>();

    public UserRepositoryImpl(Map<Integer, UserEntity> users) {
        this.users = users;
    }

    public UserRepositoryImpl() {

        users.put(1, new UserEntity(1, "Carlos", new ArrayList<>(), new ArrayList<>(Arrays.asList(2)), new ArrayList<>()));
        users.put(2, new UserEntity(2, "Felipe", new ArrayList<>(Arrays.asList(1)), new ArrayList<>(), new ArrayList<>(Arrays.asList(40,50))));
        users.put(3, new UserEntity(3, "Maria", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(Arrays.asList(60,70))));
        users.put(4, new UserEntity(4, "Elisa", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.put(5, new UserEntity(5, "Raul", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.put(6, new UserEntity(6, "Florencia", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

    }


    @Override
    public UserEntity getEntityById(Integer userId) {
        if (this.users.get(userId) == null) {
            throw new NotFoundException("No existe usuario con ID: " + userId);
        }

        return users.get(userId);
    }

    @Override
    public Map<Integer, UserEntity> getAllEntity() {
        return users;
    }


    @Override
    public void followSeller(Integer userId, Integer userIdToFollow) {

        Boolean isAlreadyFollower = users.get(userId).getFollowedList().contains(userIdToFollow);
        Boolean isTheSameEntity = userId.equals(userIdToFollow);
        if (!isAlreadyFollower && !isTheSameEntity) {

            users.get(userId).addFollowedList(userIdToFollow);
            users.get(userIdToFollow).addFollowersToList(userId);
        }
    }

    @Override
    public void unfollowSeller(Integer userId, Integer userIdToUnfollow) {
        users.get(userId).removeFollowedToList(userIdToUnfollow);
        users.get(userIdToUnfollow).removeFollowersToList(userId);
    }

    @Override
    public Boolean exist(Integer userId) {
        return users.get(userId) != null;
    }

    @Override
    public Boolean isSeller(Integer userId) {
        return users.get(userId).getPublicationList().size() > 0;
    }

}

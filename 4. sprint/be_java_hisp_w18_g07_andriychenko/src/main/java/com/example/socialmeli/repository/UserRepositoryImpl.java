package com.example.socialmeli.repository;

import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    Map<Integer, UserEntity> users = new HashMap<>();

    public UserRepositoryImpl() {

        users.put(1, new UserEntity(1, "Carlos", new ArrayList<>(), Arrays.asList(4,5,6), new ArrayList<>()));
        users.put(2, new UserEntity(2, "Felipe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.put(3, new UserEntity(3, "Maria", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.put(4, new UserEntity(4, "Elisa", new ArrayList<>(), new ArrayList<>(), Arrays.asList(1)));
        users.put(5, new UserEntity(5, "Raul", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.put(6, new UserEntity(6, "Florencia", new ArrayList<>(), new ArrayList<>(), Arrays.asList(2,3)));

    }

    @Override
    public UserEntity getEntityByID(Integer id) {
        if(this.users.get(id) == null){
            throw new NotFoundException("No existe usuario con ID: " + id);
        }

        return users.get(id);
    }

    @Override
    public Map<Integer, UserEntity> getAllEntity() {
        return users;
    }

    @Override
    public void followSeller(Integer userId, Integer userIdToFollow) {
        users.get(userId).addFollowedList(userIdToFollow); //el usuario userId sigue al usuario userIdToFollow
        users.get(userIdToFollow).addFollowersToList(userId); //al usuario userIdToFollow lo empezo a seguir el usuario userId

        System.out.println("LISTAS ACTUALIZADAS");
        System.out.println("Lista de seguidores de  " + userId + ": " + users.get(userId).getFollowedList());
        System.out.println("Lista de seguidos de " + userIdToFollow + ": " + users.get(userIdToFollow).getFollowersList());
    }

    @Override
    public boolean isSeller(Integer userIdToFollow){
        return users.get(userIdToFollow).isSeller();
    }

    @Override
    public boolean exist(Integer userId){
        return users.get(userId) != null;
    }


}

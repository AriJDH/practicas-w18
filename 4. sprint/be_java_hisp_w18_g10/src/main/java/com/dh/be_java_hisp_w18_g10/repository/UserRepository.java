package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private Map<Integer, User> users = new HashMap<Integer, User>();
    private Integer count = 0;
    public UserRepository() {
        loadUsers();
    }

    private void loadUsers(){
        users.put(count, new User());
        count++;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUserFollowers(int id) {
        return users.entrySet().stream()
                .filter(entry -> entry.getKey() == id)
                .map(entry -> entry.getValue())
                .map(user -> user.getFollowers().values())
                .flatMap(userCollection -> userCollection.stream())
                .collect(Collectors.toList());
    }
}

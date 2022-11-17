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

        count++;
        User vendedor = new User();
        vendedor.setUserId(count);
        vendedor.setUserName("vendedor1");

        count++;
        User user1 = new User();
        user1.setUserId(count);
        user1.setUserName("usuario1");

        count++;
        User user2 = new User();
        user2.setUserId(count);
        user2.setUserName("usuario2");

        vendedor.getFollowers().put(user1.getUserId(), user1);
        vendedor.getFollowers().put(user2.getUserId(), user2);

//        Map<Integer, User> followedUsuer2 = new HashMap<Integer, User>();
//        followedUsuer2.put(user3.getUserId(), user3);
//        user2.setFollowed(followedUsuer2);
//
//        Map<Integer, User> followedUsuer3 = new HashMap<Integer, User>();
//        followedUsuer3.put(user2.getUserId(), user2);
//        user3.setFollowed(followedUsuer3);
//
//        Map<Integer, User> follorers1 = new HashMap<Integer, User>();
//        follorers1.put(user2.getUserId(), user2);

        this.users.put(vendedor.getUserId(), vendedor);
        this.users.put(user1.getUserId(), user1);
        this.users.put(user2.getUserId(), user2);
    }

    @Override
    public User getUser(int id) {
        User user = users.get(id);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUserFollowers(int id) {
        return users.get(id).getFollowersList();
    }
}

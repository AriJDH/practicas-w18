package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}

package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.List;

public interface IUserRepository {
    User getUser(int id);
    List<User> getUsers();
    List<User> getUserFollowers(int id);
    List<User> getAllUsers();
}

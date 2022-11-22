package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.List;

public interface IUserRepository {
    User getUser(int userId);
    List<User> getUsers();
    List<User> getUsers(String order);
    List<User> getUserFollowers(int userId);
    List<User> getUserFollowers(int userId, String order);
    List<User> getUserFollowed(int userId);
    List<User> getUserFollowed(int userId, String order);
    int countUserPromoPosts(int userId);
    List<Post> getUserPosts(int userId);
    List<Post> getPromoPostByUser(int userId);
    void sortUserListBy(List<User> users, String order);

}

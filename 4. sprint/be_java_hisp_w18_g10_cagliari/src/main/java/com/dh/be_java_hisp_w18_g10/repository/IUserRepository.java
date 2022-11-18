package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.List;

public interface IUserRepository {
    User getUser(int id);
    List<User> getUsers();
    List<User> getUserFollowers(int id);
    int countUserPromoPosts(int userId);
    List<Post> getUserPosts(int userId);
    List<Post> getPromoPostByUser(int userId);
}

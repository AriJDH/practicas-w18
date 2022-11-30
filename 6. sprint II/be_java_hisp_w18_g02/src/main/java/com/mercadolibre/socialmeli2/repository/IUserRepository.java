package com.mercadolibre.socialmeli2.repository;

import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.User;

import java.util.List;


public interface IUserRepository {
    User findById(Integer id);
    List<User> getFollowers(Integer id);
    void createPost(Integer userId, Post newPost);
    Integer getNextPostId();
    boolean existsById(Integer id);

}

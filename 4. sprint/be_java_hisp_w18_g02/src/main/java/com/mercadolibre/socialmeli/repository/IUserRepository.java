package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IUserRepository {
    User findById(Integer id);
    List<User> getFollowers(Integer id);
    List<User> getFollowed(Integer id);
    void follow(Integer idFollower, Integer idFollow);
    void unfollow(Integer idFollower, Integer idFollow);
    void createPost(Integer userId, Post newPost);
    //List<Post> getRecentPost(Integer sellerId);
}

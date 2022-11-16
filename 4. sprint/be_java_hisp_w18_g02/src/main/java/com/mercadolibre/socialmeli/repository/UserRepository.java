package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> users;
    private static int nextPostId= 1;

    public UserRepository() {
        this.users = new HashMap<Integer, User>();

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> getFollowers(Integer id) {
        return null;
    }

    @Override
    public List<User> getFollowed(Integer id) {
        return null;
    }

    @Override
    public void follow(Integer idFollower, Integer idFollow) {

    }

    @Override
    public void unfollow(Integer idFollower, Integer idFollow) {

    }

    @Override
    public void createPost(Integer userId, Post newPost) {

    }
}

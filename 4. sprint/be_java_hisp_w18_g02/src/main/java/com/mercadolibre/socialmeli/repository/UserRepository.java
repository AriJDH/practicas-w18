package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

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
        List<User> res = new ArrayList<>();

        for(Map.Entry<Integer, User> entry : users.entrySet()) {
            Set<User> followed = entry.getValue().getFollowed();

            for(User u : followed ) {
                if(u.getId() == id) {
                    res.add(entry.getValue());
                }
            }
        }
        return res;
    }

    @Override
    public List<User> getFollowed(Integer id) {
        User user = users.get(id);
        Set<User> users = user.getFollowed();

        List<User> res = new ArrayList<>(users);
        return res;
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

package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDbService userDbService;
    @Override
    public void handleFollow(long userId, long userIdToFollow) {
        User user = userDbService.findById(userId);
        User userToFollow = userDbService.findById(userIdToFollow);
        user.follow(userToFollow);
    }

    @Override
    public void handleUnfollow(long userId, long userIdToUnfollow) {
        User user = userDbService.findById(userId);
        User userToUnfollow = userDbService.findById(userIdToUnfollow);
        user.unFollow(userToUnfollow);
    }
}

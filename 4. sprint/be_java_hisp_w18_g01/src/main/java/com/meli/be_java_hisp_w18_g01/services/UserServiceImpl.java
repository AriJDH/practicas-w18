package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.UserDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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

    @Override
    public UserFollowersCountDTO handleGetFollowersCount(long userId) {
        User user = userDbService.findById(userId);
        return new UserFollowersCountDTO(user.getUser_id(), user.getUser_name(), user.getFollowersCount());//TODO: se puede llegar a hacer mas lindo con objectMapper
    }

    @Override
    public UserFollowersInfoDTO handleGetFollowersInfo(long userId) {
        User user = userDbService.findById(userId);
        return new UserFollowersInfoDTO(user.getUser_id(), user.getUser_name(),
                user.getFollowers().stream().map(u->new UserDTO(u.getUser_id(), u.getUser_name()))
                        .collect(Collectors.toList()));
    }

    @Override
    public UserFollowedInfoDTO handleGetFollowedInfo(long userId) {
        User user = userDbService.findById(userId);
        return new UserFollowedInfoDTO(user.getUser_id(), user.getUser_name(),
                user.getFollowed().stream().map(u->new UserDTO(u.getUser_id(), u.getUser_name()))
                        .collect(Collectors.toList()));
    }
}

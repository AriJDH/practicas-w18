package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.*;

import java.util.List;

public interface UserService {
    void handleFollow(long userId, long userIdToFollow);
    void handleUnfollow(long userId, long userIdToUnfollow);
    UserFollowersCountDTO handleGetFollowersCount(long userId);
    UserFollowersInfoDTO handleGetFollowersInfo(long userId, String order);
    UserFollowedInfoDTO handleGetFollowedInfo(long userId, String order);
    List<AllUserDTO> findAllUsers(Integer userId);
}

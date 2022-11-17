package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;

public interface UserService {
    ResponseDTO handleFollow(long userId, long userIdToFollow);
    ResponseDTO handleUnfollow(long userId, long userIdToUnfollow);
    UserFollowersCountDTO handleGetFollowersCount(long userId);
    UserFollowersInfoDTO handleGetFollowersInfo(long userId);
    UserFollowedInfoDTO handleGetFollowedInfo(long userId);
}

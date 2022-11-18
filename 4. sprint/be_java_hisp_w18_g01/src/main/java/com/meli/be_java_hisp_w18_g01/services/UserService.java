package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.SellerDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;

import java.util.List;

public interface UserService {
    void handleFollow(long userId, long userIdToFollow);
    void handleUnfollow(long userId, long userIdToUnfollow);
    UserFollowersCountDTO getFollowersCount(long userId);
    UserFollowersInfoDTO getFollowersInfo(long userId, String order);
    UserFollowedInfoDTO getFollowedInfo(long userId, String order);
    SellerDTO getBestSeller();
}

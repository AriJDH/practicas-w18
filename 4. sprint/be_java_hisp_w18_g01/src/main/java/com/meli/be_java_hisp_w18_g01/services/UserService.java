package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserPremiumDTO;
import com.meli.be_java_hisp_w18_g01.entities.User;

public interface UserService {
    void handleFollow(long userId, long userIdToFollow);
    void handleUnfollow(long userId, long userIdToUnfollow);
    UserFollowersCountDTO getFollowersCount(long userId);
    UserFollowersInfoDTO getFollowersInfo(long userId, String order);
    UserFollowedInfoDTO getFollowedInfo(long userId, String order);

    boolean userPremiumLevel1(User user);
    boolean userPremiumLevel2(User user);

    UserPremiumDTO isUserPremium(long id);
}

package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;

import java.util.Optional;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    void unfollowUser(int userId, int userIdToUnfollow);
    UserFollowersCountDTO getFollowersCount(int userId);
    UserFollowedListDTO getFollowedList(int userId, String order);
    UserFollowersListDTO getFollowersList(int userId, String order);

}

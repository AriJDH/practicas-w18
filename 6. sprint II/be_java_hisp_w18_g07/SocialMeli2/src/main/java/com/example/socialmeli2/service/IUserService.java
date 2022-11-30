package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.response.UserFollowedListResponse;
import com.example.socialmeli2.dto.response.UserFollowerCountResponse;
import com.example.socialmeli2.dto.response.UserFollowersListResponse;

public interface IUserService {

    boolean followUserSeller(Integer userId, Integer userIdToFollow);

    boolean unfollowUserSeller(Integer userId, Integer userIdToUnfollow);

    UserFollowerCountResponse getUserFollowersCount(Integer userId);

    UserFollowersListResponse getFollowersUsersById(Integer userId, String order);


    UserFollowedListResponse getFollowedUsersById(Integer id, String order);

}

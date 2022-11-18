package com.example.socialmeli.service;

import com.example.socialmeli.dto.response.UserFollowedListResponse;
import com.example.socialmeli.dto.response.UserFollowerCountResponse;
import com.example.socialmeli.dto.response.UserFollowersListResponse;

public interface IUserService {


    void followUserSeller(Integer userId, Integer userIdToFollow);


    void unfollowUserSeller(Integer userId, Integer userIdToUnfollow);


    UserFollowerCountResponse getUserFollowersCount(Integer userId);

    UserFollowersListResponse getFollowersUsersById(Integer userId, String order);


    UserFollowedListResponse getFollowedUsersById(Integer id, String order);

}

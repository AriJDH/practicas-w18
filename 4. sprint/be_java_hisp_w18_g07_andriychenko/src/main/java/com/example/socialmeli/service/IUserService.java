package com.example.socialmeli.service;

import com.example.socialmeli.dto.response.UserFollowerCountResponse;
import com.example.socialmeli.dto.response.UserFollowedListResponse;
import com.example.socialmeli.dto.response.UserFollowersListResponse;

public interface IUserService {

    UserFollowerCountResponse getUserFollowersCount(int id);

    void unfollowUser(int userId, int userIdToUnfollow);

    UserFollowersListResponse getUserFollowers(int userId, String order);
    UserFollowedListResponse getFollowedUsersById(Integer id, String order);
    void followSeller(Integer userId, Integer userIdToFollow);

}

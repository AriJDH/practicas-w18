package com.sprint1.be_java_hisp_w18_g03.service;

public interface IUserService {

    ResponseDTO follow(Integer userId, Integer followId);
    FollowerCountDTO followerCount(Integer userId);
    FollowersDTO getFollowersList(Integer userId);
    FollowedDTO getFollowedList(Integer userId);
    ResponseDTO unfollow(Integer userId, Integer followId);

}

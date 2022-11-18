package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.dto.request.CreateUsersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.*;

public interface IUserService {

    ResponseDTO follow(Integer userId, Integer followId);

    FollowerCountDTO followerCount(Integer userId);

    FollowersDTO getFollowersList(Integer userId,String order);

    FollowedDTO getFollowedList(Integer userId, String order);

    ResponseDTO unfollow(Integer userId, Integer followId);

    ResponseDTO createUsers(CreateUsersDTO createUsersDTO);

    UsersDTO listUsers();
}

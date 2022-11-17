package com.meli.be_java_hisp_w18_g03_individual.service;

import com.meli.be_java_hisp_w18_g03_individual.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.FollowerCountDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.FollowersDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.ResponseDTO;

public interface IUserService {

    ResponseDTO follow(Integer userId, Integer followId);

    FollowerCountDTO followerCount(Integer userId);

    FollowersDTO getFollowersList(Integer userId, String order);

    FollowedDTO getFollowedList(Integer userId, String order);

    ResponseDTO unfollow(Integer userId, Integer followId);

}

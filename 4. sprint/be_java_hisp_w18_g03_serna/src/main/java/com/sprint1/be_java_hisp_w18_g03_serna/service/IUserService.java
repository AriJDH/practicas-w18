package com.sprint1.be_java_hisp_w18_g03_serna.service;

import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.ResponseDTO;

public interface IUserService {

    ResponseDTO follow(Integer userId, Integer followId);

    FollowerCountDTO followerCount(Integer userId);

    FollowersDTO getFollowersList(Integer userId,String order);

    FollowedDTO getFollowedList(Integer userId, String order);

    ResponseDTO unfollow(Integer userId, Integer followId);

}

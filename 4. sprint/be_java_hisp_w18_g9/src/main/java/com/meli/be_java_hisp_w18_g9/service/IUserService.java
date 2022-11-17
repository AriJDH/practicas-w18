package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IUserService {
    HttpStatus follow(Integer userId, Integer userIdToFollow) throws Throwable;

    UserFollowedListResponse findAllFollowed (Integer id);
    FollowersCountUserResponse findUserFollowedQuantity(Integer id);

    UserFollowerListResponse findAllFollower(Integer id );

}

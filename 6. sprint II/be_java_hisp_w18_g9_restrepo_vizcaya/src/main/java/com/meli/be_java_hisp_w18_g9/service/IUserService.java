package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import org.springframework.http.HttpStatus;

public interface IUserService {
    HttpStatus follow(Integer userId, Integer userIdToFollow) throws Throwable;
    HttpStatus unfollow(Integer userId, Integer userIdToUnfollow) throws Throwable;
    UserFollowedListResponse findAllFollowed (Integer id);
    FollowersCountUserResponse findUserFollowedQuantity(Integer id);
    UserFollowedListResponse findAllFollowedOrderAsc (Integer id);
    UserFollowerListResponse findAllFollowerOrderAsc (Integer id);
    UserFollowerListResponse findAllFollowerOrderDesc (Integer id);
    UserFollowedListResponse findAllFollowedOrderDesc (Integer id);
    UserFollowerListResponse findAllFollower(Integer id );

}

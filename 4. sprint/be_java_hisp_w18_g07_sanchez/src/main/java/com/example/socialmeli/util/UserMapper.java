package com.example.socialmeli.util;

import com.example.socialmeli.dto.response.*;
import com.example.socialmeli.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserBasicResponse userEntity2UserBasicResponse(UserEntity entity) {

        UserBasicResponse response = new UserBasicResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());

        return response;
    }

    public static List<UserBasicResponse> userEntityList2UserBasicResponseList(List<UserEntity> entityList) {

        List<UserBasicResponse> response = new ArrayList<>();
        for (UserEntity entity : entityList) {
            response.add(userEntity2UserBasicResponse(entity));
        }

        return response;
    }

    public static UserFollowerCountResponse userEntity2UserFollowerCountResponse(UserEntity entity){

        UserFollowerCountResponse response = new UserFollowerCountResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setFollowersCount(entity.getFollowersList().size());

        return response;
    }
    public static UserPostPromoCountResponse userPublicationPromCountResponse(UserEntity entity){

        UserPostPromoCountResponse response = new UserPostPromoCountResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPromoProductsCount(entity.getPromProductsList().size());
        return response;
    }

    public static UserFollowersListResponse userEntity2UserFollowersListResponse(UserEntity entity, List<UserBasicResponse> followedList) {

        UserFollowersListResponse response = new UserFollowersListResponse();
        response.setUserId(entity.getId());
        response.setUserName(entity.getName());
        response.setUserBasicResponseList(followedList);

        return response;
    }

    public static UserFollowedListResponse userEntity2UserFollowedListResponse(UserEntity entity, List<UserBasicResponse> followedList) {

        UserFollowedListResponse response = new UserFollowedListResponse();
        response.setUserId(entity.getId());
        response.setUserName(entity.getName());
        response.setUserBasicResponseList(followedList);

        return response;
    }

}

package com.example.socialmeli2.util;

import com.example.socialmeli2.dto.response.UserBasicResponse;
import com.example.socialmeli2.dto.response.UserFollowedListResponse;
import com.example.socialmeli2.dto.response.UserFollowerCountResponse;
import com.example.socialmeli2.dto.response.UserFollowersListResponse;
import com.example.socialmeli2.entity.UserEntity;

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

    public static UserFollowerCountResponse userEntity2UserFollowerCountResponse(UserEntity entity) {

        UserFollowerCountResponse response = new UserFollowerCountResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setFollowersCount(entity.getFollowersList().size());

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

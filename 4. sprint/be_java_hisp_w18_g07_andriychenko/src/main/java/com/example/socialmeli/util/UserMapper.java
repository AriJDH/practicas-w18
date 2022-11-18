package com.example.socialmeli.util;

import com.example.socialmeli.dto.response.UserBasicResponse;
import com.example.socialmeli.dto.response.UserFollowedListResponse;
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

    public static UserFollowedListResponse entity2UserFollowedListResponse(UserEntity entity, List<UserBasicResponse> followedList) {

        UserFollowedListResponse response = new UserFollowedListResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUserBasicResponseList(followedList);

        return response;
    }

}

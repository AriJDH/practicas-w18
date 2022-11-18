package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.dto.respose.FollowedListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostFollowedByDateDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostPromoCountDTORes;

public interface IUserBuyerService {
    void follow(Integer userId, Integer userIdToFollow);
    FollowedListDTORes getFollowed(Integer userId, String order);

    PostFollowedByDateDTORes getLastPosts(Integer userId, String order);

    void unfollow(Integer userId, Integer userIdToUnfollow);



}

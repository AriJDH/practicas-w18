package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.PostFollowedByDateDTORes;

public interface IUserBuyerService {
    void follow(Integer userId, Integer userIdToFollow);
    FollowedListDTORes getFollowed(Integer userId, String order);

    PostFollowedByDateDTORes getLastPosts(Integer userId, String order);

    void unfollow(Integer userId, Integer userIdToUnfollow);

}

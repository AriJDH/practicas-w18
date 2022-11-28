package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowDTORes;
import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.PostFollowedByDateDTORes;
import com.example.SocialMeli2.dto.respose.UnfollowDTORes;

public interface IUserBuyerService {
    FollowDTORes follow(Integer userId, Integer userIdToFollow);

    FollowedListDTORes getFollowed(Integer userId, String order);

    PostFollowedByDateDTORes getLastPosts(Integer userId, String order);

    UnfollowDTORes unfollow(Integer userId, Integer userIdToUnfollow);

}

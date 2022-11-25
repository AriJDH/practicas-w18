package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.respose.FollowerCountDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId, String order);

    void publishPost(PostDTOReq postDTOReq);

}

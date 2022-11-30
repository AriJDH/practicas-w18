package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.respose.FollowerCountDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;
import com.example.SocialMeli2.dto.respose.PostDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId, String order);

    PostDTORes publishPost(PostDTOReq postDTOReq);

}

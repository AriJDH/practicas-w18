package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerListDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId, String order);

    void publishPost(PostDTOReq postDTOReq);

    void publishPromoPost(PromoPostDTOReq promoPostDTOReq);
}

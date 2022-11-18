package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PromoPostCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PromoPostListoDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId, String order);

    void publishPost(PostDTOReq postDTOReq);

    void publishPost(PromoPostDTOReq postDTOReq);

    void publishPromoPost(PromoPostDTOReq postDTOReq);

    PromoPostCountDTORes promoPostCount(Integer userId);

    PromoPostListoDTORes promoPostList(Integer userId);

    PromoPostListoDTORes productsToPromotion(Integer userId);
}

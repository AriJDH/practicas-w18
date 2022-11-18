package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostPromoByUserDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostPromoCountDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId, String order);

    void publishPost(PostDTOReq postDTOReq);

    PostPromoCountDTORes countPostPromo(Integer user_id);

    PostPromoByUserDTORes getPostPromoByUser(Integer id);

}

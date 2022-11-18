package com.socialmedia.be_java_hisp_w18_g08_escandon.service;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PromoPostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PostDtoRes;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);
    void createPromoPost(PromoPostDtoReq promoPostDtoReq);
}

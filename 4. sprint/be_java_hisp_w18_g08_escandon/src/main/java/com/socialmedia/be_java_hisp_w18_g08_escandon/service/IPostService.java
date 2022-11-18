package com.socialmedia.be_java_hisp_w18_g08_escandon.service;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.PromoPostDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PromoPostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PromoPostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PromoPostQuantityDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.SellerFollowersCountDto;

public interface IPostService {

    void create(PostDtoReq postDTOReq);
    PostDtoRes getPostSellerListByUserId(Integer id, String order);
    void createPromoPost(PromoPostDtoReq promoPostDtoReq);
    PromoPostQuantityDto findAllPromoPostQuantity(Integer id);
    PromoPostDtoRes getAllProductsByCategory(Integer userId, Integer category);

}

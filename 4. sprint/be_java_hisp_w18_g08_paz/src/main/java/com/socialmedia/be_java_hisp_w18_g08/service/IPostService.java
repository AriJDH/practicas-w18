package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDiscountDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.SellerDiscountCountDto;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);

    void createDiscount(PostDiscountDtoReq postDiscountDtoReq);

    SellerDiscountCountDto getCountDiscount(Integer id);
}

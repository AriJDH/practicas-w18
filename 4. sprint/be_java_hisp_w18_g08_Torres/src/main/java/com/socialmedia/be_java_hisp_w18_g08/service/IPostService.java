package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostwithPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.SellerPostCountDtoRes;

public interface IPostService {

    void create(PostDtoReq postDTOReq);
    void createPostWithPromo(PostwithPromoDtoReq postwithPromoDtoReq);

    SellerPostCountDtoRes findAllPostBySeller(Integer id);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);
}

package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostPromoDtoRes;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);

    void createPromo(PostPromoDtoReq postDTOReq);

    PostPromoDtoRes getPostSellerCountByUserId(Integer userId);
}

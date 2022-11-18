package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    void createPostPromo(PostPromoDtoReq postPromoDtoReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);
}

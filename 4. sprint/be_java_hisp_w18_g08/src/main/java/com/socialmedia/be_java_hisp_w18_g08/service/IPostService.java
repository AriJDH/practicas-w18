package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;

import java.util.List;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    public PostDtoRes getPostSellerListByUserId(Integer id);
}

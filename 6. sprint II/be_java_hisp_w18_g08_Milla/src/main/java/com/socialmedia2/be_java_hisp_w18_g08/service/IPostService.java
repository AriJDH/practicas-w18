package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;

public interface IPostService {

    String create(PostDtoReq postDTOReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);
}

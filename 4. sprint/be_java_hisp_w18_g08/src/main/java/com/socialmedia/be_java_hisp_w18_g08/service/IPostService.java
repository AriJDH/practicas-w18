package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.PostDtoRes;

import java.util.List;

public interface IPostService {

    void create(PostDtoReq postDTOReq);

    public List<PostDtoRes> getPostSellerListByUserId(Integer id);
}

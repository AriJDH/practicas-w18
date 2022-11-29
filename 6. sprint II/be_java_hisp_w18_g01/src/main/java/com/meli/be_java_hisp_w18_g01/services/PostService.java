package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import com.meli.be_java_hisp_w18_g01.dtos.SellerDTO;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);
    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);
}

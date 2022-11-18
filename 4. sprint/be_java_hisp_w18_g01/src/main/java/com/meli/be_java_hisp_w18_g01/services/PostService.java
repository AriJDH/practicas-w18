package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.*;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);

    void addPostPromo(PostPromoDTO postPromoDTO);
    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);

}

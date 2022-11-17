package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.*;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);

    void addPostDisc(PostDiscDTO postDiscDTO);

    SellerPostDiscountCountDTO getPromoPostCount(long userId);

    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);


}

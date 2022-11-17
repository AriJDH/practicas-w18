package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.PromoPostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.SellerDTO;
import com.meli.be_java_hisp_w18_g01.dtos.SellerPromoPostCountDTO;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);
    void addPromoPost(PromoPostDTO promoPostDTO);
    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);
    SellerPromoPostCountDTO getSellerPromoPostCount(long userId);
}

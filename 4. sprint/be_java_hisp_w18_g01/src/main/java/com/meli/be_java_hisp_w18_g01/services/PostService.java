package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);
    void addPromoPost(PromoPostDTO promoPostDTO);
    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);
    SellerPromoPostCountDTO getSellerPromoPostCount(long userId);
    SellerPromoPostInfoDTO getSellerPromoPostInfo(long userId);
}

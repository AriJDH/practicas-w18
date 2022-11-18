package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.*;

import java.util.List;

public interface PostService {

    void addPost(PostDTO postDTO);
    List<SellerDTO> getRecentPostsFromFollowed(long userId, String order);

    void addPostPromo(PostDiscountDTO postDiscountDTO);

    CountPostDiscountDTO getPostsWithDiscountAtSeller(long userId);

    PostDiscountListDTO getDiscountPostAtSeller(long userId);


}

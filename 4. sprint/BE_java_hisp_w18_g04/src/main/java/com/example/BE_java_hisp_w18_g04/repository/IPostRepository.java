package com.example.BE_java_hisp_w18_g04.repository;

import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PostPromo;

import java.util.List;

public interface IPostRepository{
    void createPost(Post post);
    void createPromoPost(PostPromo post);
    List<PostPromo> findAllPromoPosts();
}

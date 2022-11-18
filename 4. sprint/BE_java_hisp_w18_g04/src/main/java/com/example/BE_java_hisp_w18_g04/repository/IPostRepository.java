package com.example.BE_java_hisp_w18_g04.repository;

import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PromoPost;

import java.util.List;

public interface IPostRepository{
    void createPost(Post post);
    void createPromoPost(PromoPost post);
    List<PromoPost> findAllPromoPost();

}

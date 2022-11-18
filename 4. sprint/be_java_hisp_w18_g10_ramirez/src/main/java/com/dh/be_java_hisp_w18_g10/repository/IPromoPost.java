package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;

import java.util.List;

public interface IPromoPost {
    PromoPostRepository getPromoPostById(int id);
    Integer addPost(Post promoPost);
    List<PromoPostRepository> getPromoPostList();
}

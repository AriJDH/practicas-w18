package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    void addPost(Post post);
    List<Post> findAll();
    List<Post> findAllById(Integer id);
    Post findAllPromosById(Integer promoId);
    List<Post> findAllByUserId(Integer userId);
    List<Post> findAllPromoByUserId(Integer userId);
    void update(Post post_promo);
}

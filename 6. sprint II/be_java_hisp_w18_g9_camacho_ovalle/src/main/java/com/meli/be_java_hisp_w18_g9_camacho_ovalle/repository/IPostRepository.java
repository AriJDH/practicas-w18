package com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Post;

import java.util.List;

public interface IPostRepository {
    void addPost(Post post);
    List<Post> findAll();
    Post findById(Integer id);
    List<Post> findAllById(Integer id);
}

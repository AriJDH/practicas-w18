package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Post;

import java.util.List;

public interface IPostRepository {
    void addPost(Post post);
    List<Post> findAll();
    List<Post> findAllById(Integer id);
    List<Post> findAllByUserId(Integer userId);
}

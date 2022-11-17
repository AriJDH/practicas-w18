package com.meli.be_java_hisp_w18_g03_individual.Repository;

import com.meli.be_java_hisp_w18_g03_individual.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post findByIdPost(Integer postId);

    List<Post> findByUser(Integer userId);

    boolean addPost(Post post);

    Integer getPostsSizeList();
}

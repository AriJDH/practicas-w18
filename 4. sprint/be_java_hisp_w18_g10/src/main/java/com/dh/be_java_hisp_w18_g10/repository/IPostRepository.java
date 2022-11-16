package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;

import java.util.List;

public interface IPostRepository {

    Post getPostById(int id);
    void addPost(Post post);
    List<Post> getPosts();

}

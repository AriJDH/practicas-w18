package com.socialmedia2.be_java_hisp_w18_g08.repository;

import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;

import java.util.List;

public interface IPostRepository {

    void save(Post post);

    void clearRepo();
    List<Post> getAll();
    Post getById(Integer id);
    Boolean add(Post post);
}

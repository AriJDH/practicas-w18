package com.socialmedia.be_java_hisp_w18_g08_escandon.repository;

import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Post;

import java.util.List;

public interface IPostRepository {

    void save(Post post);
    List<Post> getAll();
    Post getById(Integer id);
    Boolean add(Post post);
}

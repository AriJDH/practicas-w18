package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAll();
    Post getById(Integer id);
    Boolean add(Post post);
}

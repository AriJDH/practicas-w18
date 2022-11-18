package com.sprint1.be_java_hisp_w18_g03_serna.Repository;

import com.sprint1.be_java_hisp_w18_g03_serna.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post findByIdPost(Integer postId);
    List<Post> findByUser(Integer userId);
    boolean addPost(Post post);

    Integer getPostsSizeList();
}

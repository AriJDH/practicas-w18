package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post findByIdPost(int postId);
    List<Post> findByUser(int userId);
     void addPost(Post post);
}

package com.dh.be_java_hisp_w18_g10.repository;
import com.dh.be_java_hisp_w18_g10.entity.Post;

import java.util.List;

public interface IPostRepository {

    Post getPostById(int id);
    Integer addPost(Post post);
    List<Post> getPosts();
    List<Post> getUserPosts(int userId);
    List<Post> getUserPostsFilterByDays(int userId, int days);
    List<Post> getUserPostsFilterByDays(int userId, int days, String order);

}

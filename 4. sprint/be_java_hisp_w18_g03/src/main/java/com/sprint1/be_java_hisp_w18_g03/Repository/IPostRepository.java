package com.sprint1.be_java_hisp_w18_g03.Repository;

import java.util.List;

public interface IPostRepository {
    Post findByIdPost(int postId);
    List<Post> findByUser(int userId);
     boolean addPost(Post post);

    Integer getPostsSizeList();
}

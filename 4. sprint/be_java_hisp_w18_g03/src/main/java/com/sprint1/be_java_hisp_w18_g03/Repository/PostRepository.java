package com.sprint1.be_java_hisp_w18_g03.Repository;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository extends IpostRepository {
    private List<Post> Posts = new ArrayList<Post>();

    public Post findByIdPost(int postId) {
        return Posts.get(postId);
    }

    public List<Post> findByUser(int userId) {
        return Posts;
    }

    public void addPost(Post post) {
    }
}

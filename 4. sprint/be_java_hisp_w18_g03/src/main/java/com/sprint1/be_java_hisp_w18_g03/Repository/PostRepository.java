package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts = new ArrayList<Post>();

    public Post findByIdPost(int postId) {
        return posts.get(postId);
    }

    public List<Post> findByUser(int userId) {
        return posts.stream()
                .filter(post -> post.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public boolean addPost(Post post) {
        posts.add(post);
        return true;
    }

    public Integer getPostsSizeList() {
        return posts.size();
    }
}

package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository{

    private Map<Integer, Post> posts = new HashMap<Integer, Post>();
    private Integer count = 0;

    @Override
    public Post getPostById(int id) {
        return null;
    }

    @Override
    public Integer addPost(Post post) {
        posts.put(count, post);
        count++;
        return count-1;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }
}

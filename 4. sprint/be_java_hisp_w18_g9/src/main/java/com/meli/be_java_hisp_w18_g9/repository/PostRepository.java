package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements  IPostRepository{
    List<Post> posts = new ArrayList<>();

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }
}

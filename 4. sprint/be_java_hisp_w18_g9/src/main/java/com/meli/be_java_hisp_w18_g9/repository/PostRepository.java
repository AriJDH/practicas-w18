package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements  IPostRepository{

    // ? =============== Attributes =============== ?
    private static final List<Post> posts = new ArrayList<>();

    // ? =============== Methods =============== ?

    @Override
    public void addPost(Post post) {
        post.setPostId(posts.size() + 1);
        posts.add(post);
    }

    // * ===============

    @Override
    public List<Post> findAll() {
        return posts;
    }

    // * ===============

    @Override
    public List<Post> findAllById(Integer id) {
        return posts.stream().filter(post -> post.getPostId().equals(id)).collect(Collectors.toList());
    }

    // * ===============

    @Override
    public List<Post> findAllByUserId(Integer userId) {
        return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
    }

}

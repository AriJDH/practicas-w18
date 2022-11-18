package com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements  IPostRepository{

    // ? =============== Attributes =============== ?
    private static final List<Post> posts = new ArrayList<>();

    // ? =============== Methods =============== ?

    /**
     * save a post
     * @param post post to save
     */
    @Override
    public void addPost(Post post) {
        post.setPostId(posts.size() + 1);
        posts.add(post);
    }

    // * ===============

    /**
     * Get all posts
     * @return List<Post>
     */
    @Override
    public List<Post> findAll() {
        return posts;
    }

    // * ===============

    /**
     * Get all posts by Id
     * @param id user to search
     * @return List<Post>
     */
    @Override
    public List<Post> findAllById(Integer id) {
        return posts.stream().filter(post -> post.getPostId().equals(id)).collect(Collectors.toList());
    }

    // * ===============

    /**
     * Get post by Id
     * @param id post to search
     * @return Post
     */
    @Override
    public Post findById(Integer id) {
        return posts.stream().filter(post -> post.getPostId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException(String.format("Post with id %d not found", id)));
    }
}

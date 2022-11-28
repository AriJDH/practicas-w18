package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    public static Post getPost(){
        Post post = new Post();
        post.setPost_id(3);
        post.setDate(LocalDate.of(2022,03,25));
        post.setCategory(2);
        post.setPrice(2500.13);
        return post;
    }

    public static List<Post> getPostList(){
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setPost_id(3);
        post.setDate(LocalDate.of(2022,03,25));
        post.setProduct(ProductFactory.getProduct());
        post.setCategory(2);
        post.setPrice(2500.13);
        postList.add(post);
        return postList;
    }




}

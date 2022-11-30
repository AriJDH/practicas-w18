package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.Post;
import com.example.SocialMeli2.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostFactory {


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

    public static Post getPost(Integer post_id, LocalDate date, Product product, Integer category, Double price){
        Post post= new Post();
        post.setPost_id(post_id);
        post.setDate(date);
        post.setProduct(product);
        post.setCategory(category);
        post.setPrice(price);

        return post;
    }

    public static List<Post> getPostListTwoWeeksBySeller4(){
        List<Post> postList = new ArrayList<>();
        Post post9= new Post();
        post9.setPost_id(9);
        post9.setDate(LocalDate.now().minusDays(13));
        post9.setProduct(ProductFactory.getProduct9());
        post9.setCategory(2);
        post9.setPrice(450.00);

        Post post10= new Post();
        post10.setPost_id(10);
        post10.setDate(LocalDate.now().minusDays(9));
        post10.setProduct(ProductFactory.getProduct10());
        post10.setCategory(3);
        post10.setPrice(4500.00);

        postList.add(post9);
        postList.add(post10);
        return postList;
    }




}

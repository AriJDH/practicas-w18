package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;
import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    public static List<Post> getPostSellers() {
        List<Post> postSellers = new ArrayList<>();
        User user = UserFactory.getSeller();
        Product product = ProductFactory.getProduct();

        Post post1 = new Post();
        post1.setPostId(1);
        post1.setUser(user);
        post1.setDate(LocalDate.of(2022,05,12));
        post1.setProducto(product);

        Post post2 = new Post();
        post2.setPostId(2);
        post2.setUser(user);
        post2.setDate(LocalDate.now());
        post2.setProducto(product);

        postSellers.add(post1);
        postSellers.add(post2);
        return postSellers;
    }

    public static List<Post> getPostSellersOrder() {
        List<Post> postSellers = new ArrayList<>();
        User user = UserFactory.getSeller();
        Product product = ProductFactory.getProduct();

        Post post1 = new Post();
        post1.setPostId(1);
        post1.setUser(user);
        post1.setDate(LocalDate.now().minusDays(2));
        post1.setProducto(product);

        Post post2 = new Post();
        post2.setPostId(2);
        post2.setUser(user);
        post2.setDate(LocalDate.now());
        post2.setProducto(product);

        postSellers.add(post1);
        postSellers.add(post2);
        return postSellers;
    }
}

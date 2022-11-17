package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements  IPostRepository{
    @Autowired
    IEntityRepository productRepository = new ProductRepository();
    @Override
    public void addPost(Post post) {
        Product product = new Product(
                post.getProduct().getProductId(),
                post.getProduct().getProductName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes());
        Post post1 = new Post(post.getUserId(), post.getDate(),product, post.getCategory(), post.getPrice());
    }
}

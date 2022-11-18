package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
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

    @Override
    public Post findAllPromosById(Integer promoId) {
        Post post;
        try {
            post = posts.stream().filter(f->f.getPostId().equals(promoId)).findAny().get();
        } catch (Exception e) {
            throw new BadRequestException("Promo with id "+promoId+" not found");
        }
        return post;
    }

    // * ===============

    @Override
    public List<Post> findAllByUserId(Integer userId) {
        return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public List<Post> findAllPromoByUserId(Integer userId) {
        List<Post> postList = new ArrayList<>();
        for (Post post: posts) {
            Post postItem = new Post();

            if(post.getHasPromo() == null){
                postItem.setHasPromo(false);
            }
            else{
                postItem.setHasPromo(post.getHasPromo());
            }

            if(post.getDiscount() == null){
                postItem.setDiscount(0.0);
            }
            else{
                postItem.setDiscount(post.getDiscount());
            }

            postItem.setPostId(post.getPostId());
            postItem.setCategory(post.getCategory());
            postItem.setPrice(post.getPrice());
            postItem.setUserId(post.getUserId());
            postItem.setProduct(post.getProduct());
            postItem.setDate(post.getDate());
            postList.add(postItem);
        }
        return postList.stream().filter(Post::getHasPromo).collect(Collectors.toList());
    }

    @Override
    public void update(Post postPromo) {
        Post postDelete = posts.stream().filter(f->f.getPostId().equals(postPromo.getPostId())).findAny().get();
        posts.remove(postDelete);
        posts.add(postPromo);

    }

}

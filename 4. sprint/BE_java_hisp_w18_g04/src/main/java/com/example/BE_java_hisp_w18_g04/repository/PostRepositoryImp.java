package com.example.BE_java_hisp_w18_g04.repository;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PromoPost;
import com.example.BE_java_hisp_w18_g04.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImp implements IPostRepository{
    List<Post> posts = new ArrayList<>();
    List<PromoPost> promoPosts = new ArrayList<>();

    public PostRepositoryImp() {
        loadPosts();
    }

    public void createPromoPost(PromoPost post){
        promoPosts.add(post);
    }

    @Override
    public List<PromoPost> findAllPromoPost() {
        return promoPosts;
    }

    public void createPost(Post post){
        if(posts.isEmpty())
            post.setPost_id(1);
        else
            post.setPost_id(posts.get(posts.size()-1).getPost_id()+1);
        posts.add(post);
    }
    private void loadPosts(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:posts.json");
            posts = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<Post>>() {});
        }catch (Exception ex){
            System.out.println("Posts not found " + ex.getMessage());
        }
    }


}

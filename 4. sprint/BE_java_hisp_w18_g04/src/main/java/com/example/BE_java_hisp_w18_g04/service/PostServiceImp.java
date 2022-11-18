package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.repository.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{
    private final IPostRepository postRepository;
    public PostServiceImp(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }


}

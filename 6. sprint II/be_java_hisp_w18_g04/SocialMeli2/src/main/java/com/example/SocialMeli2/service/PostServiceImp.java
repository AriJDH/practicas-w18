package com.example.SocialMeli2.service;

import com.example.SocialMeli2.repository.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{
    private final IPostRepository postRepository;
    public PostServiceImp(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }




}

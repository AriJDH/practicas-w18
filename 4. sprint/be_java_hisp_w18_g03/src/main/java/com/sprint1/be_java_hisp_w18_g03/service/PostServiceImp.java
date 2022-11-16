package com.sprint1.be_java_hisp_w18_g03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.be_java_hisp_w18_g03.repository.IPostRepository;

@Service
public class PostServiceImp implements IPostService{

    @Autowired
    private IPostRepository iPostRepository;


    @Override
    public ResponseDTO createPost(RequestPostDTO request) {
        return null;
    }

    @Override
    public SellerPostDTO getPostSellet(Integer userId) {
        return null;
    }
}

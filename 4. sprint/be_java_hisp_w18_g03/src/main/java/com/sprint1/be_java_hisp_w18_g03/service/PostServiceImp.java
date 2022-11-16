package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{

    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public ResponseDTO createPost(RequestPostDTO request) {
        return null;
    }

    @Override
    public SellersPostDTO getPostSellet(Integer userId) {
        return null;
    }
}

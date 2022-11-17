package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostService implements  IPostService{
    @Autowired
    IPostRepository iPostRepository;
    private final ObjectMapper mapper;

    public PostService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addPost(PostDtoRequest postDtoRequest) {
        Post post = mapper.convertValue(postDtoRequest, Post.class);
        iPostRepository.addPost(post);
    }

    @Override
    public List<PostDtoResponse> findAll() {
        List<Post> postDtoResponseList = iPostRepository.findAll();
        return postDtoResponseList.stream()
                .map(post -> mapper.convertValue(post, PostDtoResponse.class))
                .collect(Collectors.toList());
    }
}

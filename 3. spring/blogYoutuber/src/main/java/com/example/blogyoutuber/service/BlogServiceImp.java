package com.example.blogyoutuber.service;

import com.example.blogyoutuber.dto.request.BlogDTORequest;
import com.example.blogyoutuber.entity.BlogPost;
import com.example.blogyoutuber.repository.BlogRepositoryImp;
import com.example.blogyoutuber.repository.IBlogRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImp implements IBlogService{

    private final IBlogRepository blogRepository;
    private final ObjectMapper objectMapper;

    public BlogServiceImp(BlogRepositoryImp blogRepository, ObjectMapper objectMapper) {
        this.blogRepository = blogRepository;
        this.objectMapper = objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    @Override
    public Long createBlog(BlogDTORequest blogDTORequest) {
        BlogPost blogPost = objectMapper.convertValue(blogDTORequest, BlogPost.class);
        return blogRepository.createBlog(blogPost);
    }
}

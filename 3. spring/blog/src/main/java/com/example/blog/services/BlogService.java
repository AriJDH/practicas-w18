package com.example.blog.services;

import com.example.blog.dtos.BlogDTO;

import java.util.List;

public interface BlogService {
    void createBlog(BlogDTO blogDTO);
    BlogDTO getBlog(long id);
    List<BlogDTO> findAll();
}

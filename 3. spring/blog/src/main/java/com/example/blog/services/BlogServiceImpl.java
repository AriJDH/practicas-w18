package com.example.blog.services;

import com.example.blog.dtos.BlogDTO;
import com.example.blog.services.dbServices.BlogDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogDbService blogDbService;

    @Override
    public void createBlog(BlogDTO blogDTO) {
        blogDbService.add(blogDTO.toBlog());
    }

    @Override
    public BlogDTO getBlog(long id) {
        return BlogDTO.fromBlog(blogDbService.findById(id));
    }

    @Override
    public List<BlogDTO> findAll() {
        return blogDbService.findAll().stream()
                .map(blog-> BlogDTO.fromBlog(blog))
                .collect(Collectors.toList());
    }
}

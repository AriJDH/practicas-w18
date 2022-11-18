package com.example.blog.services.dbServices;

import com.example.blog.entities.Blog;

import java.util.List;

public interface BlogDbService {
    Blog findById(long id);
    void add(Blog blog);
    List<Blog> findAll();
}

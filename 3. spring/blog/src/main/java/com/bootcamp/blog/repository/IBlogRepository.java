package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    void addBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> getAllBlogs();

    List<EntradaBlog> findById(Integer id);
}

package com.ejercicios.blog.repository;

import com.ejercicios.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    EntradaBlog findBlogById(Integer id);
    void addBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> findBlogs();
    boolean hasId(Integer id);
}

package com.dh.blog.repository;

import com.dh.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    EntradaBlog findBlogById(Integer id);
    void addBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> findBlogs();
    boolean hasId(Integer id);
}

package com.meli.springmanejoexcepcionesp1vivo.repository;

import com.meli.springmanejoexcepcionesp1vivo.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog selectBlog(Integer id);
    Blog createBlog(Blog blog);
    List<Blog> getAllBlog();
}

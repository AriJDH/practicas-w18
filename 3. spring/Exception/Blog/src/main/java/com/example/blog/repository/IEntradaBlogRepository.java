package com.example.blog.repository;

import com.example.blog.dto.BlogDTO;

import java.util.HashMap;
import java.util.List;

public interface IEntradaBlogRepository {


    public void agregarBlog(BlogDTO blog);
    public BlogDTO buscarBlogPorID(String id);
    public List<BlogDTO> devolverBlog();
}

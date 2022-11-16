package com.example.Blog.repository;

import com.example.Blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {

    public EntradaBlog agregarBlog(EntradaBlog blog);
    public EntradaBlog buscarBlog(Long id);
    public List<EntradaBlog> buscarTodos();
}

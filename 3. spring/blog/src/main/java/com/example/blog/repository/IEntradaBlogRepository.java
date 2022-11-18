package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    void createBlog(EntradaBlog entradaBlog);

    List<EntradaBlog> findAll();

    EntradaBlog findyById(Integer id);
}

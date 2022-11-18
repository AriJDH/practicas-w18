package com.example.demo.repository;

import com.example.demo.model.EntradaBlog;

import java.util.List;

public interface EntradaBlogRepositoryI {

    public EntradaBlog nuevoBlog(EntradaBlog entrada);

    public EntradaBlog findById(Long id);

    public List<EntradaBlog> getBlogs();
}

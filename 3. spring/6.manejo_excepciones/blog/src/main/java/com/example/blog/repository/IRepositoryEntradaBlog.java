package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IRepositoryEntradaBlog {
     void add(EntradaBlog entrada);
     List<EntradaBlog> listAll();
     EntradaBlog findById(Long id);
}

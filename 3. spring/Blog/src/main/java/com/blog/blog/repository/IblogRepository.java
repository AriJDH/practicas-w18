package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;

import java.util.List;

public interface IblogRepository {

    List<EntradaBlog> findAll();
    EntradaBlog findById(Long id);
    Long addEntradaBlog(EntradaBlog entrada);

}

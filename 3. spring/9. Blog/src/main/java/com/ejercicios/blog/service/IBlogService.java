package com.ejercicios.blog.service;

import com.ejercicios.blog.dto.EntradaBlogDTO;

import java.util.List;

public interface IBlogService {

    void addBlogEntry(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO findBlogById(Integer id);
    List<EntradaBlogDTO> findBlogEntries();

}

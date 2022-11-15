package com.dh.blog.service;

import com.dh.blog.dto.EntradaBlogDTO;

import java.util.List;

public interface IBlogService {

    void addBlogEntry(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO findBlogById(Integer id);
    List<EntradaBlogDTO> findBlogEntries();

}

package com.example.Blog.service;

import com.example.Blog.dto.EntradaBlogDtoRequest;
import com.example.Blog.dto.EntradaBlogDtoResponse;
import com.example.Blog.dto.EntradaBlogIdDtoResponse;

import java.util.List;

public interface IEntradaBlogService {

    public EntradaBlogDtoResponse agregarBlog(EntradaBlogDtoRequest blog);
    public EntradaBlogIdDtoResponse buscarBlog(Long id);
    public List<EntradaBlogIdDtoResponse> buscarTodos();
}

package com.example.demo.service;

import com.example.demo.dtos.EntradaBlogDTO;

import java.util.List;

public interface EntradaBlogServiceI {

    public EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO);

    public EntradaBlogDTO getBlog(Long id);

    public List<EntradaBlogDTO> getBlogs();
}

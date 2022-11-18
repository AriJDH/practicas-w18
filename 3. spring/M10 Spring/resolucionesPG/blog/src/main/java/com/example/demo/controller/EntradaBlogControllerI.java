package com.example.demo.controller;

import com.example.demo.dtos.EntradaBlogDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EntradaBlogControllerI {

    @PostMapping("/blog")
    public EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getBlog(@PathVariable Long id);

    @GetMapping("/blogs")
    public List<EntradaBlogDTO> getBlogs();
}

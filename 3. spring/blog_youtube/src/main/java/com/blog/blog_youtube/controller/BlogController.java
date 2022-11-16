package com.blog.blog_youtube.controller;

import com.blog.blog_youtube.dto.EntradaBlogDTO;
import com.blog.blog_youtube.dto.EntradaBlogInDTO;
import com.blog.blog_youtube.dto.EntradaBlogOutDTO;
import com.blog.blog_youtube.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private IBlogService iBlogService;

    public BlogController(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogOutDTO> crearBlog(@RequestBody EntradaBlogInDTO entradaBlogInDTO) {
        return new ResponseEntity<>(iBlogService.crearBlog(entradaBlogInDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> crearBlog(@PathVariable Long id) {
        return new ResponseEntity<>(iBlogService.consultarBlogPorId(id), HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDTO>> findAll() {
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }
}

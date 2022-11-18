package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.service.BlogService;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    IBlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntryDTO> findEntry(@PathVariable Long id){
        BlogEntryDTO entrada = blogService.findById(id);
        return ResponseEntity.ok().body(entrada);
    }

    @PostMapping
    public ResponseEntity<BlogEntryDTO> addEntry(@RequestBody BlogEntryDTO entradaBlogDTO){
        blogService.addEntryBlog(entradaBlogDTO);
        return ResponseEntity.ok().body(entradaBlogDTO);
    }
}
package com.dh.blog.controller;

import com.dh.blog.dto.EntradaBlogDTO;
import com.dh.blog.service.BlogService;
import com.dh.blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {
    public final IBlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/addBlog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO blogDTO) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("")
    public ResponseEntity<?> getBlogEntries(){
        return null;
    }
}

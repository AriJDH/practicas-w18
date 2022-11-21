package com.ejercicios.blog.controller;

import com.ejercicios.blog.dto.EntradaBlogDTO;
import com.ejercicios.blog.service.BlogService;
import com.ejercicios.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    public final IBlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/addBlog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO blogDTO) {
        blogService.addBlogEntry(blogDTO);
        return new ResponseEntity<>("Blog agregado correctamente.", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        EntradaBlogDTO blogDTO = blogService.findBlogById(id);
        return ResponseEntity.ok().body(blogDTO);
    }

    @GetMapping("")
    public ResponseEntity<?> getBlogEntries(){
        List<EntradaBlogDTO> entradasBlog = blogService.findBlogEntries();
        return ResponseEntity.ok().body(entradasBlog);
    }
}

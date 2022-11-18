package com.example.blog.controllers;

import com.example.blog.dtos.BlogDTO;
import com.example.blog.dtos.ResponseDTO;
import com.example.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> createBlog(@RequestBody BlogDTO blogDTO){
        blogService.createBlog(blogDTO);
        return ResponseEntity.ok(new ResponseDTO("El blog " + blogDTO.getId() + " pudo ser creado correctamente.", 200 ));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable long id){
        return ResponseEntity.ok(blogService.getBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getBlogs(){
        return ResponseEntity.ok(blogService.findAll());
    }
}

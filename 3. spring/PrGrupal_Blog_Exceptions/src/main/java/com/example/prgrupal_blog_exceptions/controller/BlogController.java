package com.example.prgrupal_blog_exceptions.controller;

import com.example.prgrupal_blog_exceptions.dto.request.EntradaBlogDtoReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody EntradaBlogDtoReq nuevoBlog){

    }
}

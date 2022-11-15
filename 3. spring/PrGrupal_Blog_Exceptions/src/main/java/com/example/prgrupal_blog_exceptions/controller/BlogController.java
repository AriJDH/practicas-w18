package com.example.prgrupal_blog_exceptions.controller;

import com.example.prgrupal_blog_exceptions.dto.request.EntradaBlogDtoReq;
import com.example.prgrupal_blog_exceptions.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    IEntradaBlogService servicioBlog;

    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody EntradaBlogDtoReq nuevoBlog){
        return new ResponseEntity<>(servicioBlog.crearEntradaBlog(nuevoBlog), HttpStatus.valueOf(201));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> consultarBlog(@PathVariable String id){
        return new ResponseEntity<>(servicioBlog.obtenerEntradaBlog(id), HttpStatus.valueOf(200));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerBlogs(){
        return new ResponseEntity<>(servicioBlog.obtenerTodasLasEntradas(), HttpStatus.valueOf(200));
    }
}

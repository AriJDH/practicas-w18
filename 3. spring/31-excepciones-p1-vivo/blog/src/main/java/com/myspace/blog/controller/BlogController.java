package com.myspace.blog.controller;

import com.myspace.blog.dto.request.EntradaBlogDTOReq;
import com.myspace.blog.dto.response.BlogDTORes;
import com.myspace.blog.dto.response.CreadoDTORes;
import com.myspace.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<CreadoDTORes> addBlog(@RequestBody EntradaBlogDTOReq entradaBlogDTOReq){
        return blogService.addBlog(entradaBlogDTOReq);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTORes> getBlogById(@PathVariable int id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTORes>> getBlogById() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

}

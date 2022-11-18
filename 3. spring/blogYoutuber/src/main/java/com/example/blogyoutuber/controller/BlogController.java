package com.example.blogyoutuber.controller;

import com.example.blogyoutuber.dto.request.BlogDTORequest;
import com.example.blogyoutuber.service.BlogServiceImp;
import com.example.blogyoutuber.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    private final IBlogService blogService;

    public BlogController(BlogServiceImp blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<Long> createBlog(@RequestBody BlogDTORequest blogDTORequest){
        return new ResponseEntity<>(blogService.createBlog(blogDTORequest), HttpStatus.CREATED);
    }
}

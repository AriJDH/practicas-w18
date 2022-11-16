package com.meli.be_java_hisp_w18_g01.controllers;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> followUser(@RequestBody PostDTO postDTO){
        postService.addPost(postDTO);
        return ResponseEntity.ok().build();
    }
}

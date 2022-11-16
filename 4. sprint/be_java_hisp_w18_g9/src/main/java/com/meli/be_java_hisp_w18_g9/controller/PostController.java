package com.meli.be_java_hisp_w18_g9.controller;

import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    IPostService iPostService;
    @PostMapping("/products/post")
    public ResponseEntity<String> addPost(@RequestBody PostDtoRequest postDtoRequest){
        iPostService.addPost(postDtoRequest);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

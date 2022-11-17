package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.entity.dto.PostDTOReq;
import com.socialmedia.be_java_hisp_w18_g08.service.IPostService;
import com.socialmedia.be_java_hisp_w18_g08.service.PostServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImp postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTOReq>createPost(@RequestBody PostDTOReq postDTOReq){
        return postService.create(postDTOReq);
    }
}

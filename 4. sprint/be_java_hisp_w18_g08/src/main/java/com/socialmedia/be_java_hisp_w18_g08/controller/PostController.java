package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.service.IPostService;
import com.socialmedia.be_java_hisp_w18_g08.service.PostServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class PostController {

    IPostService postService;

    public PostController(PostServiceImp postService){
        this.postService=postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDtoRes>> getPostSellerListByUserId(@PathVariable Integer userId){
        List<PostDtoRes> response =  postService.getPostSellerListByUserId(userId);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}

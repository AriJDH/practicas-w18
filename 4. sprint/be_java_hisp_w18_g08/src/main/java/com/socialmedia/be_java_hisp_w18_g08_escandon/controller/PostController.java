package com.socialmedia.be_java_hisp_w18_g08_escandon.controller;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.service.IPostService;
import com.socialmedia.be_java_hisp_w18_g08_escandon.service.PostServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PostDtoRes;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImp postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String>createPost(@RequestBody PostDtoReq postDTOReq) {
        postService.create(postDTOReq);
        return new ResponseEntity<>("Post created with success", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostDtoRes> getPostSellerListByUserId(@PathVariable Integer userId,
                                                                      @RequestParam(required = false) String order){
        PostDtoRes response =  postService.getPostSellerListByUserId(userId, order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

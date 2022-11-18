package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostwithPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.SellerPostCountDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.service.IPostService;
import com.socialmedia.be_java_hisp_w18_g08.service.PostServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;

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

    @PostMapping("/promo-post")
    public ResponseEntity<String>createPost(@RequestBody PostwithPromoDtoReq postwithPromoDtoReq){
        postService.createPostWithPromo(postwithPromoDtoReq);
        return new ResponseEntity<>("post with promo created successfully", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostDtoRes> getPostSellerListByUserId(@PathVariable Integer userId,
                                                                      @RequestParam(required = false) String order){
        PostDtoRes response =  postService.getPostSellerListByUserId(userId, order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPostCountDtoRes> findPostBySellerQuantity(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.findAllPostBySeller(user_id), HttpStatus.OK);
    }




}

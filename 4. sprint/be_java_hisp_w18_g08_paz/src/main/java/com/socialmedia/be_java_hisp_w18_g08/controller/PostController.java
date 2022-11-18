package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDiscountDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.SellerDiscountCountDto;
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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostDtoRes> getPostSellerListByUserId(@PathVariable Integer userId,
                                                                      @RequestParam(required = false) String order){
        PostDtoRes response =  postService.getPostSellerListByUserId(userId, order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> createPostDiscount(@RequestBody PostDiscountDtoReq postDiscountDto) {
        postService.createDiscount(postDiscountDto);
        return new ResponseEntity<>("Product with discount applied successfully", HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerDiscountCountDto> getCountSellerDiscount(@RequestParam Integer user_id){
        SellerDiscountCountDto sellerDiscount = postService.getCountDiscount(user_id);
        return new ResponseEntity<>(sellerDiscount, HttpStatus.OK);
    }
}

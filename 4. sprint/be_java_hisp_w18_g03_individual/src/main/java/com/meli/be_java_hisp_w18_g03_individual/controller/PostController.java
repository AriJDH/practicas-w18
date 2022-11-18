package com.meli.be_java_hisp_w18_g03_individual.controller;

import com.meli.be_java_hisp_w18_g03_individual.dto.request.RequestPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.request.RequestPromoPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.PromoPostCountDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.ResponseDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.SellerPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.SellerPromoPostResponseDTO;
import com.meli.be_java_hisp_w18_g03_individual.service.IPostService;
import com.meli.be_java_hisp_w18_g03_individual.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private IUserService userService;

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody RequestPostDTO requestPostDTO) {
        return new ResponseEntity<>(postService.createPost(requestPostDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPostDTO> getPostSellers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(postService.getPostSellers(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromoPost(@RequestBody RequestPromoPostDTO requestPromoPostDTO) {
        return new ResponseEntity<>(postService.createPromoPost(requestPromoPostDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountUser(@RequestParam(name="user_id") Integer userId) {
        return ResponseEntity.ok(postService.getPromoPostCountUser(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoPostResponseDTO> getPromoPostListUser(@RequestParam(name="user_id") Integer userId) {
        return ResponseEntity.ok(postService.getPromoPostListUser(userId));
    }
}

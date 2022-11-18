package com.meli.be_java_hisp_w18_g01.controllers;

import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addPost(@RequestBody PostDTO postDTO){
        postService.addPost(postDTO);
        return ResponseEntity.ok(new ResponseDTO(200,"operación exitosa"));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<SellerDTO>> getRecentPostsFromFollowed(@PathVariable long userId, @RequestParam(required=false) String order){
        return ResponseEntity.ok(postService.getRecentPostsFromFollowed(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> addPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        postService.addPromoPost(promoPostDTO);
        return ResponseEntity.ok(new ResponseDTO(200, "operación exitosa"));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoPostCountDTO> getSellerPromoPostCount(@RequestParam long userId){
        return ResponseEntity.ok(postService.getSellerPromoPostCount(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoPostInfoDTO> getSellerPromoPostInfo(@RequestParam long userId){
        return ResponseEntity.ok(postService.getSellerPromoPostInfo(userId));
    }
}

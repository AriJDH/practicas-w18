package com.socialmedia.be_java_hisp_w18_g08_escandon.controller;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.PromoPostDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.PromoPostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PromoPostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.PromoPostQuantityDto;
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

    @PostMapping("/promo-post")
    public ResponseEntity<String>createPromoPost(@RequestBody PromoPostDtoReq promoPostDto) {
        postService.createPromoPost(promoPostDto);
        return new ResponseEntity<>("Post created with success", HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostQuantityDto> getAllPromoProductsBySeller(@RequestParam Integer user_id) {
        PromoPostQuantityDto dto = postService.findAllPromoPostQuantity(user_id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostDtoRes> getAllProductsByCategory(@RequestParam Integer user_id, Integer category){
        PromoPostDtoRes dto =  postService.getAllProductsByCategory(user_id, category);
        return ResponseEntity.ok().body(dto);
    }
}

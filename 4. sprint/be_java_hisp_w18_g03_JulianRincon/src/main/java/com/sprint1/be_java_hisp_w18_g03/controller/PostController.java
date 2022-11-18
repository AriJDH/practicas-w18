package com.sprint1.be_java_hisp_w18_g03.controller;

import com.sprint1.be_java_hisp_w18_g03.dto.request.PromoPostDTORequest;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.PromoPostCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.service.IPostService;
import com.sprint1.be_java_hisp_w18_g03.service.IUserService;
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
    public ResponseEntity<SellersPostDTO> getPostSellers(@PathVariable Integer userId,
                                                         @RequestParam(required = false) String order
    ) {
        return ResponseEntity.ok(postService.getPostSellers(userId,order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromoPost(@RequestBody PromoPostDTORequest promoPostDTORequest){
        return new ResponseEntity<>(postService.createPromoPost(promoPostDTORequest), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getCountPromoPost(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPostPromoCount(user_id),HttpStatus.OK);
    }

    @GetMapping("/promo-post/followed")
    public ResponseEntity<?> getPromoPostsFollowed(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoPostFollowed(user_id),HttpStatus.OK);
    }
}

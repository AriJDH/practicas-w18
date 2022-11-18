package com.example.BE_java_hisp_w18_g04.controller;

import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.*;
import com.example.BE_java_hisp_w18_g04.service.IPostService;
import com.example.BE_java_hisp_w18_g04.service.IUserBuyerService;
import com.example.BE_java_hisp_w18_g04.service.IUserSellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    private final IUserBuyerService userBuyerService;
    private final IUserSellerService userSellerService;

    private final IPostService postService;

    public SocialMeliController(IUserBuyerService userBuyerService, IUserSellerService userSellerService, IPostService postService) {
        this.userBuyerService = userBuyerService;
        this.userSellerService = userSellerService;
        this.postService = postService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userBuyerService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTORes> followersCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(userSellerService.followersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTORes> getFollowers(@PathVariable Integer userId, @RequestParam String order) {
        return new ResponseEntity<>(userSellerService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTORes> getFollowed(@PathVariable Integer userId, @RequestParam String order) {
        return new ResponseEntity<>(userBuyerService.getFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> publishPost(@RequestBody PostDTOReq postDTOReq) {
        userSellerService.publishPost(postDTOReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostFollowedByDateDTORes> getLastPosts(@PathVariable Integer userId, @RequestParam String order) {
        return new ResponseEntity<>(userBuyerService.getLastPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        userBuyerService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Ejercicios individuales
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> publishPromoPost(@RequestBody PromoPostDTOReq postDTOReq) {
        userSellerService.publishPromoPost(postDTOReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDTORes> promoPostCount(@RequestParam String user_id) {
        System.out.println(user_id);
        Integer id = Integer.valueOf(String.valueOf(user_id));
       PromoPostCountDTORes response =   userSellerService.promoPostCount(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostListoDTORes> promoPostlist(@RequestParam String user_id) {
        System.out.println(user_id);
        Integer id = Integer.valueOf(String.valueOf(user_id));
        PromoPostListoDTORes response = userSellerService.promoPostList(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/products-to-promotion")
    public ResponseEntity<PromoPostListoDTORes> productsToPromotion(@RequestParam String user_id) {
        System.out.println(user_id);
        Integer id = Integer.valueOf(String.valueOf(user_id));
        PromoPostListoDTORes response = userSellerService.productsToPromotion(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

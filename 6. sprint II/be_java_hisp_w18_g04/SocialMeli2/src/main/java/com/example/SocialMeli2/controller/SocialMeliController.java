package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.respose.*;
import com.example.SocialMeli2.service.IUserBuyerService;
import com.example.SocialMeli2.service.IUserSellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SocialMeliController {

    private final IUserBuyerService userBuyerService;
    private final IUserSellerService userSellerService;


    public SocialMeliController(IUserBuyerService userBuyerService, IUserSellerService userSellerService) {
        this.userBuyerService = userBuyerService;
        this.userSellerService = userSellerService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTORes> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        FollowDTORes followDTORes = userBuyerService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(followDTORes,HttpStatus.OK);
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
    public ResponseEntity<?> publishPost(@Valid @RequestBody PostDTOReq postDTOReq) {
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

}

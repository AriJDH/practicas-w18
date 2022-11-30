package com.example.SocialMeli2.controller;

import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.respose.*;
import com.example.SocialMeli2.service.IUserBuyerService;
import com.example.SocialMeli2.service.IUserSellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
public class SocialMeliController {

    private final IUserBuyerService userBuyerService;
    private final IUserSellerService userSellerService;


    public SocialMeliController(IUserBuyerService userBuyerService, IUserSellerService userSellerService) {
        this.userBuyerService = userBuyerService;
        this.userSellerService = userSellerService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTORes> follow(@PathVariable(value = "userId")
                                               @Positive(message = "The user id must be greater than 0") Integer userId,
                                               @PathVariable(value = "userIdToFollow")
                                               @Positive(message = "The user id must be greater than 0") Integer userIdToFollow) {
        FollowDTORes followDTORes = userBuyerService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(followDTORes, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTORes> followersCount(@PathVariable(value = "userId")
                                                              @Positive(message = "The user id must be greater than 0")
                                                              Integer userId) {
        return new ResponseEntity<>(userSellerService.followersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTORes> getFollowers(@PathVariable(value = "userId")
                                                           @Positive(message = "The user id must be greater than 0") Integer userId,
                                                           @RequestParam(required = true) String order) {
        return new ResponseEntity<>(userSellerService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTORes> getFollowed(@PathVariable(value = "userId")
                                                          @Positive(message = "The user id must be greater than 0") Integer userId,
                                                          @RequestParam String order) {
        return new ResponseEntity<>(userBuyerService.getFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<PostDTORes> publishPost(@Valid @RequestBody PostDTOReq postDTOReq) {
        PostDTORes postDTORes = userSellerService.publishPost(postDTOReq);
        return new ResponseEntity<>(postDTORes, HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostFollowedByDateDTORes> getLastPosts(@PathVariable(value = "userId")
                                                                 @Positive(message = "The user id must be greater than 0") Integer userId,
                                                                 @RequestParam String order) {
        return new ResponseEntity<>(userBuyerService.getLastPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowDTORes> unfollow(@PathVariable(value = "userId")
                                                   @Positive(message = "The user id must be greater than 0") Integer userId,
                                                   @PathVariable(value = "userIdToUnfollow")
                                                   @Positive(message = "The user id must be greater than 0") Integer userIdToUnfollow) {
        UnfollowDTORes unfollowDTORes = userBuyerService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(unfollowDTORes, HttpStatus.OK);
    }

}

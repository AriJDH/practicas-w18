package com.socialmeli.be_java_hisp_w18g05.controller;


import com.socialmeli.be_java_hisp_w18g05.dto.request.PostPromoDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.service.IService;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {

    private IService service;

    public SocialController(ServiceImp service) {
        this.service = service;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}") //US0001
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        service.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count") //US0002
    public ResponseEntity<SellerFollowersCountDTOResponse> followersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(service.followersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list") //US0003 & US0008
    public ResponseEntity<SellerFollowersListDTOResponse> followersList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followersFilter(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list") // US0004 & US0008
    public ResponseEntity<BuyerFollowedListDTOResponse> followedList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followedsFilter(userId, order),HttpStatus.OK);
    }

    @PostMapping("/products/post") //US0005
    public ResponseEntity<?> addPost(@RequestBody NewPostDTORequest post){
        service.newPost(post);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list") //US0006 & US0009
    public ResponseEntity<SellerPostListDTOResponse> followedPostList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followedPostList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}") //US0007
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        service.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/products/promo-post") //US0010
    public ResponseEntity<?> postPromo(@RequestBody PostPromoDTORequest post){
        service.postPromo(post);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count") //US0011
    public ResponseEntity<PostPromoCountDTOResponse> postPromoCount(@RequestParam Integer user_id) {
        return new ResponseEntity<>(service.postPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/total-post") // US0012
    public ResponseEntity<?> getAllPost(){
        return new ResponseEntity<>(service.totalCountPostSeller(),HttpStatus.OK);
    }


}
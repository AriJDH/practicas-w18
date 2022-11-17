package com.socialmeli.be_java_hisp_w18g05.controller;


import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.service.IService;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class SocialController {
    private IService service;

    public SocialController(ServiceImp service) {
        this.service = service;
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDTOResponse> followersList(@PathVariable Integer userId){
        return new ResponseEntity<>(service.getFollowers(userId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        service.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        service.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDTOResponse> followersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(service.followersCount(userId), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<String> addPost(@RequestBody NewPostDTORequest post){
        service.newPost(post);
        return new ResponseEntity<>( "Post realizado correctamente ", HttpStatus.OK);
    }


}

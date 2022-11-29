package com.socialmeli.be_java_hisp_w18g05.controller;


import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;


import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerFollowedListDTOResponse;


import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerPostListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.service.IService;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class SocialController {
    private IService service;

    public SocialController(ServiceImp service) {
        this.service = service;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}") //US0001
    public ResponseEntity<?> follow(@PathVariable @NotNull(message = "User id can not be empty")
                                                  @Min(value = 0, message = "User id must be greater than zero") Integer userId,
                                                  @PathVariable @NotNull(message = "User id can not be empty")
                                                  @Min(value = 0, message = "User id must be greater than zero") Integer userIdToFollow){
        service.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count") //US0002
    public ResponseEntity<SellerFollowersCountDTOResponse> followersCount(@PathVariable @NotNull(message = "User id can not be empty")
                                                                                        @Min(value = 0, message = "User id must be greater than zero") Integer userId){
        return new ResponseEntity<>(service.followersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list") //US0003 & US0008
    public ResponseEntity<SellerFollowersListDTOResponse> followersList(@PathVariable @NotNull(message = "User id can not be empty")
                                                                            @Min(value = 0, message = "User id must be greater than zero") Integer userId,
                                                                        @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followersFilter(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list") // US0004 & US0008
    public ResponseEntity<BuyerFollowedListDTOResponse> followedList(@PathVariable @NotNull(message = "User id can not be empty")
                                                                         @Min(value = 0, message = "User id must be greater than zero")  Integer userId,
                                                                     @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followedsFilter(userId, order),HttpStatus.OK);
    }

    @PostMapping("/products/post") //US0005
    public ResponseEntity<?> addPost(@RequestBody @Valid NewPostDTORequest post){
        service.newPost(post);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list") //US0006 & US0009
    public ResponseEntity<SellerPostListDTOResponse> followedPostList(@PathVariable @NotNull(message = "User id can not be empty")
                                                                          @Min(value = 0, message = "User id must be greater than zero")  Integer userId,
                                                                      @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.followedPostList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}") //US0007
    public ResponseEntity<?> unfollow(@PathVariable @NotNull(message = "User id can not be empty")
                                          @Min(value = 0, message = "User id must be greater than zero")  Integer userId,
                                      @PathVariable Integer userIdToUnfollow){
        service.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

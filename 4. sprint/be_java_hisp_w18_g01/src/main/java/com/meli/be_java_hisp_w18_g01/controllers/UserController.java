package com.meli.be_java_hisp_w18_g01.controllers;

import com.meli.be_java_hisp_w18_g01.dtos.UserFollowedInfoDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersCountDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;
import com.meli.be_java_hisp_w18_g01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable long userId, @PathVariable long userIdToFollow){
        userService.handleFollow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable long userId, @PathVariable long userIdToUnfollow){
        userService.handleUnfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> getFollowersCount(@PathVariable long userId){
        return ResponseEntity.ok(userService.handleGetFollowersCount(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersInfoDTO> getFollowersInfo(@PathVariable long userId){
        return ResponseEntity.ok(userService.handleGetFollowersInfo(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedInfoDTO> getFollowedInfo(@PathVariable long userId){
        return ResponseEntity.ok(userService.handleGetFollowedInfo(userId));
    }
}

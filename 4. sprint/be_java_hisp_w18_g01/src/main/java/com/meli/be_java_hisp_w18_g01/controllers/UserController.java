package com.meli.be_java_hisp_w18_g01.controllers;

import com.meli.be_java_hisp_w18_g01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

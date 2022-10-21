package com.example.socialmeli.controller;

import com.example.socialmeli.dto.response.UserFollowedListResponse;
import com.example.socialmeli.dto.response.UserFollowerCountResponse;
import com.example.socialmeli.dto.response.UserFollowersListResponse;
import com.example.socialmeli.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    //US 001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUserSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {

        userService.followUserSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 007
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowUserSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {

        userService.unfollowUserSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 004
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListResponse> getUsersFollowed(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order) {

        return new ResponseEntity<>(userService.getFollowedUsersById(userId, order), HttpStatus.OK);
    }

    //US 003
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListResponse> getUsersFollowers(@PathVariable int userId, @RequestParam(defaultValue = "") String order) {

        return new ResponseEntity<>(userService.getFollowersUsersById(userId, order), HttpStatus.OK);
    }

    //US 002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountResponse> getUserFollowersCount(@PathVariable int userId) {

        return new ResponseEntity<>(userService.getUserFollowersCount(userId), HttpStatus.OK);
    }

}

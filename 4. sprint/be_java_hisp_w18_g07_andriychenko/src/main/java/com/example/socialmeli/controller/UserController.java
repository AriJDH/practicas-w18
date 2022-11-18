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

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListResponse> getFollowedUsersById(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order){

        UserFollowedListResponse response = userService.getFollowedUsersById(userId , order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //    US 0003  y US 0008
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListResponse> getUserFollowers(@PathVariable int userId, @RequestParam(defaultValue = "") String order){
        return ResponseEntity.ok(userService.getUserFollowers(userId, order));
    }

//    US 0001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public void followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        userService.followSeller(userId, userIdToFollow);
    }

// US 002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountResponse> getUserFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(this.userService.getUserFollowersCount(userId), HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        this.userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>("Usuario removido", HttpStatus.OK);
    }

}

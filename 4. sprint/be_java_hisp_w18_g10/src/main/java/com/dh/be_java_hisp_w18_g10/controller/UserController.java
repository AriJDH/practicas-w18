package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.service.IUserService;
import com.dh.be_java_hisp_w18_g10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private IUserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable String userId,
            @PathVariable String userIdToFollow
    ) {
        return null;
    }
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTOres> getUserFollowersCount(
      @PathVariable int userId
    ){
        // US 0002
        return new ResponseEntity<>(userService.getUserFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getUserFollowers(
            @RequestParam(required = false) String order,
            @PathVariable int userId
    ){
        // US 0003
        // US 0008
        return null;
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getUserFollowedList(
            @RequestParam(required = false) String order,
            @PathVariable String userId
    ) {
        // US 0004
        // US 0008
        return null;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(
            @RequestBody PostDTOreq postDTOreq
            ){
        // US 0005
        return null;
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getUserFollowedPost(
            @RequestParam(required = false) String order,
            @PathVariable int userId){
        // US 0006
        // US 0009
        return null;
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowedUserById(
            @PathVariable int userId,
            @PathVariable int userIdToUnfollow
    ){
        // US 0007
        userService.unfollowUser(userId, userIdToUnfollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }




}

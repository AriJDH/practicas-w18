package com.sprint1.be_java_hisp_w18_g03.controller;

import com.sprint1.be_java_hisp_w18_g03.dto.request.CreateUsersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.*;
import com.sprint1.be_java_hisp_w18_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> followerCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.followerCount(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollow(userId,userIdToUnfollow),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getListFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersList(userId,order), HttpStatus.OK);
    }

    @PostMapping("/createUsers")
    public ResponseEntity<ResponseDTO> createUsers(@RequestBody CreateUsersDTO createUsersDTO) {
        return new ResponseEntity<>(userService.createUsers(createUsersDTO), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<UsersDTO> listUsers() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }
}

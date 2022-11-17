package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.service.IUserService;
import com.socialmedia.be_java_hisp_w18_g08.service.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController (UserServiceImp service){
        this.userService = service;
    }

    @GetMapping("/{userId}/followed/list")
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDtoRes> follow (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        FollowDtoReq followDtoReq = new FollowDtoReq(userId, userIdToFollow);
        return new ResponseEntity(userService.follow(followDtoReq), HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable Integer userId){
        return new ResponseEntity(userService.getFollowed(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListDTO> findUserListBySeller(@PathVariable Integer userId){
        UserListDTO userListDTO = userService.findUserListBySeller(userId);
        return ResponseEntity.ok().body(userListDTO);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unFollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.unFollow(userId,userIdToUnfollow),HttpStatus.OK);
    }
}

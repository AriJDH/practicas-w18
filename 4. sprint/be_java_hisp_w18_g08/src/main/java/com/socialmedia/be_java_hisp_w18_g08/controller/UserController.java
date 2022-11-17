package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerFollowersCountDTO;
import com.socialmedia.be_java_hisp_w18_g08.service.IUserService;
import com.socialmedia.be_java_hisp_w18_g08.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;

    public UserController (UserServiceImp service){
        this.userService = service;
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable Integer userId){
        return new ResponseEntity(userService.getFollowed(userId), HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDTO> findAllFollowersQuantity(@PathVariable long userId){
        return new ResponseEntity<>(userService.findAllFollowersQuantity(userId), HttpStatus.OK);
    }
}

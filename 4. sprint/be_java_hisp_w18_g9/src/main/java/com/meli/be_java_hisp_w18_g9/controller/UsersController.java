package com.meli.be_java_hisp_w18_g9.controller;

import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.service.IUserService;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    //UserService userService = new UserService();
    @Autowired
    IUserService userService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> getPlatoInfoPlato(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws Throwable {
        return new ResponseEntity<>(userService.follow(userId,userIdToFollow));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListResponse> userFollowedList(@PathVariable Integer userId){

        return new ResponseEntity<>(userService.findAllFollowed(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountUserResponse> userFollowedQuantity(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.findUserFollowedQuantity(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerListResponse> userFollowerList(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.findAllFollower(userId),HttpStatus.OK);
    }

}

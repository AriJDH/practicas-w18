package com.socialmedia.be_java_hisp_w18_g08_escandon.controller;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.UserListDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.FollowDtoRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.FollowedDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.SellerFollowersCountDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.service.IUserService;
import com.socialmedia.be_java_hisp_w18_g08_escandon.service.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController(UserServiceImp service) {
        this.userService = service;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDtoRes> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        FollowDtoReq followDtoReq = new FollowDtoReq(userId, userIdToFollow);
        return new ResponseEntity<>(userService.follow(followDtoReq), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDto> getFollowed(@PathVariable Integer userId,
                                                   @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDto> findAllFollowersQuantity(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.findAllFollowersQuantity(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListDto> findUserListBySeller(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        UserListDto userListDTO = userService.findUserListBySeller(userId, order);
        return ResponseEntity.ok().body(userListDTO);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unFollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.unFollow(userId,userIdToUnfollow),HttpStatus.OK);
    }
}
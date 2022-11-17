package com.socialmedia.be_java_hisp_w18_g08.controller;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerFollowersCountDTO;
import com.socialmedia.be_java_hisp_w18_g08.service.IUserService;
import com.socialmedia.be_java_hisp_w18_g08.service.UserServiceImp;
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
        return new ResponseEntity(userService.follow(followDtoReq), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable Integer userId,
                                                   @RequestParam(required = false) String order) {
        return new ResponseEntity(userService.getFollowed(userId, order), HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDTO> findAllFollowersQuantity(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.findAllFollowersQuantity(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListDTO> findUserListBySeller(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        UserListDTO userListDTO = userService.findUserListBySeller(userId, order);
        return ResponseEntity.ok().body(userListDTO);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unFollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.unFollow(userId,userIdToUnfollow),HttpStatus.OK);
    }
}

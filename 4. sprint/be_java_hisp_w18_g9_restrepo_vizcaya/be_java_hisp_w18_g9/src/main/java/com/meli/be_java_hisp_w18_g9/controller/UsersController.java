package com.meli.be_java_hisp_w18_g9.controller;


import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.service.IUserService;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    // ? =============== Attributes =============== ?
    private final IUserService userService;

    // ? =============== Methods =============== ?

    // * ===== [GET] ===== *

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListResponse> userFollowedListOrder (@RequestParam(required = false) String order, @PathVariable Integer userId){

        UserFollowedListResponse userFollowedListResponseOrder = userService.findAllFollowed(userId);

        if (order != null) {
            if (order.equals("name_asc")) {
                userFollowedListResponseOrder = userService.findAllFollowedOrderAsc(userId);
            } else if (order.equals("name_desc")) {
                userFollowedListResponseOrder = userService.findAllFollowedOrderDesc(userId);
            } else
                throw new BadRequestException("invalid parameters");
        }

        return new ResponseEntity<>(userFollowedListResponseOrder, HttpStatus.OK);

    }

    // * ============== *
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountUserResponse> userFollowedQuantity (@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.findUserFollowedQuantity(userId), HttpStatus.OK);
    }

    // * ============== *

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerListResponse> userFollowerList (@PathVariable Integer userId , @RequestParam(required= false) String order){

        UserFollowerListResponse userFollowerListOrder = userService.findAllFollower(userId);

        if (order != null){

            if(order.equals("name_asc")){
                userFollowerListOrder = userService.findAllFollowerOrderAsc(userId);
            } else if (order.equals("name_desc")) {
                userFollowerListOrder = userService.findAllFollowerOrderDesc(userId);
            } else{
                throw new BadRequestException("invalid parameters");
            }
        }

        return new ResponseEntity<>(userFollowerListOrder, HttpStatus.OK);

    }

    // * ===== [POST] ===== *
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> follow (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws Throwable {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow));
    }

    // * ============== *
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollowUser (@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws Throwable {
        return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow));
    }

}

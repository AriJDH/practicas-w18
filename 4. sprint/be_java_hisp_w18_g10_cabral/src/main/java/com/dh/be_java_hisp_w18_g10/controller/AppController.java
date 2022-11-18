package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.PostPromoDTOReq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.service.IAppService;
import com.dh.be_java_hisp_w18_g10.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private IAppService userService;
    public AppController(AppService userService) {
        this.userService = userService;
    }
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable int userId,
            @PathVariable int userIdToFollow
    ) {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTOres> getUserFollowersCount(
      @PathVariable int userId
    ){
        // US 0002
        return new ResponseEntity<>(userService.getUserFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTOres> getUserFollowers(
            @RequestParam(required = false) String order,
            @PathVariable int userId) {
        // US 0003
        // US 0008
        if(order != null)
            return new ResponseEntity<>(userService.getUserFollowerList(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(userService.getUserFollowerList(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getUserFollowedList(
            @RequestParam(required = false) String order,
            @PathVariable int userId
    ) {
        // US 0004
        // US 0008
        if(order != null)
            return new ResponseEntity<>(userService.getUserFollowed(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(userService.getUserFollowed(userId),HttpStatus.OK);

    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(
            @RequestBody PostDTOreq postDTOreq
            ){
        // US 0005
        userService.createPost(postDTOreq);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserPostsDTOres> getUserFollowedPost(
            @RequestParam(required = false) String order,
            @PathVariable int userId){
        // US 0006
        // US 0009
        return new ResponseEntity<>(userService.getUserPosts(userId, order), HttpStatus.OK);
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

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPostPromo(
            @RequestBody PostPromoDTOReq postPromoDTOReq
    ){
        // US 0010
        userService.createPostPromo(postPromoDTOReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<UserProductPromoCountDTOres> getProductPromoCount(
            @RequestParam int user_id
    ){
        // US 0011
        return new ResponseEntity<>(userService.getProductPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/highPromoList")
    public ResponseEntity<UserHighProductPromoListDTOres> getHighProductPromoList(
            @RequestParam int user_id, double discount
    ){
        // US 0012
        return new ResponseEntity<>(userService.getHighProductPromoList(user_id, discount), HttpStatus.OK);
    }


}

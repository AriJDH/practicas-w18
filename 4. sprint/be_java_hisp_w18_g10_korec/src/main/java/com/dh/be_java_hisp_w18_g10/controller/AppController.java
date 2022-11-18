package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.PostPromoDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.PostPromoCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.service.IAppService;
import com.dh.be_java_hisp_w18_g10.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private IAppService iAppService;

    public AppController(AppService userService) {
        this.iAppService = userService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable int userId,
            @PathVariable int userIdToFollow
    ) {
        iAppService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTOres> getUserFollowersCount(
            @PathVariable int userId
    ) {
        // US 0002
        return new ResponseEntity<>(iAppService.getUserFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTOres> getUserFollowers(@RequestParam(required = false) String order, @PathVariable int userId) {
        // US 0003
        // US 0008
        if (order != null)
            return new ResponseEntity<>(iAppService.getUserFollowerList(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(iAppService.getUserFollowerList(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getUserFollowedList(@RequestParam(required = false) String order, @PathVariable int userId) {
        // US 0004
        // US 0008
        if (order != null)
            return new ResponseEntity<>(iAppService.getUserFollowed(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(iAppService.getUserFollowed(userId), HttpStatus.OK);

    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDTOreq postDTOreq) {
        // US 0005
        iAppService.createPost(postDTOreq);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserPostsDTOres> getUserFollowedPost(
            @RequestParam(required = false) String order,
            @PathVariable int userId) {
        // US 0006
        // US 0009
        return new ResponseEntity<>(iAppService.getUserPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowedUserById(
            @PathVariable int userId,
            @PathVariable int userIdToUnfollow
    ) {
        // US 0007
        iAppService.unfollowUser(userId, userIdToUnfollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //----------------------------APARTADO INDIVIDUAL------------------------------------
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPostPromo(@RequestBody PostPromoDTOreq postDTOreq) {
        // US 0010
        iAppService.createPromoPost(postDTOreq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PostPromoCountDTOres> getPostPromoCount(@RequestParam int user_id) {
        // US 0011
        return new ResponseEntity<>(iAppService.getPostPromoCount(user_id), HttpStatus.OK);
    }

   /* @GetMapping("/users")
    public ResponseEntity<?> getUsers(){

    }*/
}

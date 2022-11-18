package com.dh.be_java_hisp_w18_g10.controller;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductOnPromotionDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPromoPostCountDTOres;
import com.dh.be_java_hisp_w18_g10.service.IAppService;
import com.dh.be_java_hisp_w18_g10.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    private IAppService appService;
    public AppController(AppService userService) {
        this.appService = userService;
    }
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable int userId,
            @PathVariable int userIdToFollow
    ) {
        appService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTOres> getUserFollowersCount(
      @PathVariable int userId
    ){
        // US 0002
        return new ResponseEntity<>(appService.getUserFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTOres> getUserFollowers(
            @RequestParam(required = false) String order,
            @PathVariable int userId) {
        // US 0003
        // US 0008
        if(order != null)
            return new ResponseEntity<>(appService.getUserFollowerList(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(appService.getUserFollowerList(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getUserFollowedList
            (@RequestParam(required = false) String order, @PathVariable int userId) {
        // US 0004
        // US 0008
        if(order != null)
            return new ResponseEntity<>(appService.getUserFollowed(userId, order), HttpStatus.OK);

        return new ResponseEntity<>(appService.getUserFollowed(userId),HttpStatus.OK);

    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(
            @RequestBody PostDTOreq postDTOreq
            ){
        // US 0005
        appService.createPost(postDTOreq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserPostsDTOres> getUserFollowedPost(
            @RequestParam(required = false) String order,
            @PathVariable int userId){
        // US 0006
        // US 0009
        return new ResponseEntity<>(appService.getUserPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowedUserById(
            @PathVariable int userId,
            @PathVariable int userIdToUnfollow
    ){
        appService.unfollowUser(userId, userIdToUnfollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0010
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody ProductOnPromotionDTOreq productOnPromotionDTOreq){
        // US 0005
        appService.createPromoPost(productOnPromotionDTOreq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0011
    @GetMapping("/products/promo-post/count") // equivale a: /products/promo-post/count?user_id={userId}
    public ResponseEntity<UserPromoPostCountDTOres> getProductsOnPromoCount(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(appService.getUserPromoPostCount(userId), HttpStatus.OK);
    }

    //US 0012 MUESTRA TODOS LOS POST CON PROMOCION
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<UserPostsDTOres> getProductsOnPromo(){
        return new ResponseEntity(appService.getPromoPost(), HttpStatus.OK);
    }
}

package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
import com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * US0005
     * @param postReq
     * @return
     */
    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDtoReq postReq){
        userService.addPost(postReq);
        return ResponseEntity.ok().build();
    }

    /**
     * US0006
     * @param userId
     * @return
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDtoRes> getRecentPost(@PathVariable Integer userId,
                                                           @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getRecentPosts(userId, order));
    }

    /**
     * US0002
     * @param userId
     * @return
     */
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerFollowerCountDtoRes> getCount(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getCount(userId));
    }

    /**
     * US0003
     * @param userId
     * @param order
     * @return
     */
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowerListDtoRes> getFollowers(@PathVariable Integer userId,
                                                                 @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getFollowers(userId, order));
    }

    /**
     * US0004
     * @param userId
     * @param order
     * @return
     */
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDtoRes> getFollowed(@PathVariable Integer userId,
                                                              @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getFollowed(userId, order));
    }

    /**
     * US0001
     * @param userId
     * @param userIdToFollow
     * @return
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.valueOf(200));
    }

    /**
     * US0007
     * @param userId
     * @param userIdToFollow
     * @return
     */
    @PostMapping("/users/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.unfollow(userId, userIdToFollow), HttpStatus.valueOf(200));
    }

}

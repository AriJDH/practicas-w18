package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.dto.request.PostDiscountDtoReq;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * US0001
     * Follow Seller
     * @param userId User ID
     * @param userIdToFollow Seller ID
     * @return 200 OK (String message)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    /**
     * US0002
     * Count Followers
     * @param userId Seller ID
     * @return 200 OK (SellerFollowerCountDtoRes Number of Followers)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerFollowerCountDtoRes> getCount(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getCount(userId));
    }

    /**
     * US0003 / US0008
     * Get Followers
     * @param userId Seller ID
     * @param order (optional) name_asc / name_desc
     * @return 200 OK (SellerFollowerListDtoRes List of Followers)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowerListDtoRes> getFollowers(@PathVariable Integer userId,
                                                                 @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getFollowers(userId, order));
    }

    /**
     * US0004 / US0008
     * Get Followed
     * @param userId User ID
     * @param order (optional) name_asc / name_desc
     * @return 200 OK (UserFollowedListDtoRes List of followed)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDtoRes> getFollowed(@PathVariable Integer userId,
                                                              @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getFollowed(userId, order));
    }

    /**
     * US0005
     * Add Post
     * @param postReq Post
     * @return 200 OK
     *         400 Bad Request (ErrorDTO Error details)
     */
    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDtoReq postReq){
        userService.addPost(postReq);
        return ResponseEntity.ok().build();
    }

    /**
     * US0006 / US0009
     * Get Recent Posts
     * @param userId User ID
     * @return 200 OK (RecentPostsDtoRes List of Recent Posts)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDtoRes> getRecentPost(@PathVariable Integer userId,
                                                           @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getRecentPosts(userId, order));
    }

    /**
     * US0007
     * Unfollow Seller
     * @param userId User ID
     * @param userIdToUnfollow Seller ID
     * @return 200 OK (String message)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }

    /**
     * US00010
     * Add a promo
     * @param postDiscountDtoReq PostDiscountDtoReq
     * @return 200 OK
     *         400 Bad Request (ErrorDTO Error details)
     */
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> setDiscount(@RequestBody PostDiscountDtoReq postDiscountDtoReq){
        userService.addPostWithPromo(postDiscountDtoReq);
        return ResponseEntity.ok().build();
    }

    /**
     * US0011
     * Count Promo Products
     * @param user_id Seller ID
     * @return 200 OK (CountPromoDtoRes)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<CountPromoDtoRes> getCountPromo(@RequestParam Integer user_id) {
        return ResponseEntity.ok(userService.getCountPromo(user_id));
    }

    /**
     * US0012
     * List Promo Products
     * @param user_id Seller ID
     * @return 200 OK (PromoPostsDtoRes)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostsDtoRes> getPromoPost(@RequestParam Integer user_id, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getPromoPost(user_id, order));
    }

    /**
     * US0012
     * Count Products
     * @param user_id Seller ID
     * @return 200 OK (CountProductsDtoRes)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/post/count")
    public ResponseEntity<CountProductsDtoRes> getCountProducts(@RequestParam Integer user_id) {
        return ResponseEntity.ok(userService.getCountProducts(user_id));
    }

    /**
     * US0012
     * Product List
     * @param user_id Seller ID
     * @return 200 OK (PromoPostsDtoRes)
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/post/list")
    public ResponseEntity<PostsDtoRes> getAllPost(@RequestParam Integer user_id, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getAllPost(user_id, order));
    }


}

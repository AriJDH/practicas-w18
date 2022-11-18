package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.request.PromoPostDtoReq;
import com.mercadolibre.socialmeli.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
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
     * US0010
     * Add Promo Post
     * @param promoPostDtoReq
     * @return 200 OK
     *         400 Bad Request (ErrorDTO Error details)
     */
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PromoPostDtoReq promoPostDtoReq){
        userService.addPromoPost(promoPostDtoReq);
        return ResponseEntity.ok().build();
    }

    /**
     * US0011
     * Get Promo Post Count From Seller
     * @param user_id
     * @return 200 OK
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoPostsCount(@RequestParam Integer user_id) {
        return ResponseEntity.ok(userService.getPromoPostsCount(user_id));
    }

    /**
     * US0012
     * Get Promo Posts From Seller
     * @param user_id
     * @return 200 OK
     *         400 Bad Request (ErrorDTO Error details)
     */
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostsFromSeller(@RequestParam Integer user_id){
        return ResponseEntity.ok(userService.getPromoPostsFromSeller(user_id));
    }
}

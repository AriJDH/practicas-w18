package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.dto.ResponseDto;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.PostsGroupedByUserDtoRes;
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
     * @return 200 OK (ResponseDto message)
     *         400 Bad Request (ResponseDto Error details)
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return ResponseEntity.ok(new ResponseDto(userService.follow(userId, userIdToFollow),200));
    }

    /**
     * US0002
     * Count Followers
     * @param userId Seller ID
     * @return 200 OK (SellerFollowerCountDtoRes Number of Followers)
     *         400 Bad Request (ResponseDto Error details)
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
     *         400 Bad Request (ResponseDto Error details)
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
     *         400 Bad Request (ResponseDto Error details)
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
     *         400 Bad Request (ResponseDto Error details)
     */
    @PostMapping("/products/post")
    public ResponseEntity<ResponseDto> addPost(@RequestBody PostDtoReq postReq){
        userService.addPost(postReq);
        return ResponseEntity.ok(new ResponseDto("Publicación realizada con éxito.",200));
    }

    /**
     * US0006 / US0009
     * Get Recent Posts
     * @param userId User ID
     * @return 200 OK (RecentPostsDtoRes List of Recent Posts)
     *         400 Bad Request (ResponseDto Error details)
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostsGroupedByUserDtoRes> getRecentPost(@PathVariable Integer userId,
                                                                  @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getRecentPosts(userId, order));
    }

    /**
     * US0007
     * Unfollow Seller
     * @param userId User ID
     * @param userIdToUnfollow Seller ID
     * @return 200 OK (String message)
     *         400 Bad Request (ResponseDto Error details)
     */
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return ResponseEntity.ok(new ResponseDto(userService.unfollow(userId, userIdToUnfollow),200));
    }

    /**
     * US0010
     * Add PromoPost
     * @param promoPostReq Post
     * @return 200 OK
     *         400 Bad Request (ResponseDto Error details)
     */
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDtoReq promoPostReq){
        userService.addPost(promoPostReq);
        return ResponseEntity.ok(new ResponseDto("Publicación realizada con éxito.",200));
    }

    /**
     * US0011
     * Get Seller´s Promo Post count
     * @param userId Seller´s Id
     * @return 200 OK (SellerPromoCountDtoRes containing requested data)
     *         400 Bad Request (ResponseDto Error details)
     */
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getSellerPromoCount(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(userService.getSellerPromoCount(userId));
    }

    /**
     * US0012
     * Get All Seller's Promo Posts
     * @param userId Seller ID
     * @param order (optional) name_asc / name_desc
     * @return 200 OK (PostsGroupedByUserDtoRes List of Seller´s Promo Posts)
     *         400 Bad Request (ResponseDto Error details)
     */
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getSellerPromoList(@RequestParam("user_id") Integer userId,
                                                @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getSellerPromoList(userId, order));
    }

    /**
     * US0013
     * Get All Promo Posts
     * @param order (optional) name_asc / name_desc
     * @return 200 OK (List<PostDtoRes> List of Promo Posts)
     *         400 Bad Request (ResponseDto Error details)
     */
    @GetMapping("/products/promo-post/list/all")
    public ResponseEntity<?> getAllPromos(@RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getAllPromos(order));
    }
}

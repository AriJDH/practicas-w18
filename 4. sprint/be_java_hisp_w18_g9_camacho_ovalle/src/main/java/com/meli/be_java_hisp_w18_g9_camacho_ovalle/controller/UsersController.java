package com.meli.be_java_hisp_w18_g9_camacho_ovalle.controller;


import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    // ? =============== Attributes =============== ?
    private final IUserService userService;

    // ? =============== Methods =============== ?

    // * ===== [GET] ===== *

    /**
     * Endpoint to get all users followed by a user ID
     * @param order Order by name (Optional - ASC or DESC)
     * @param userId User ID
     * @return UserFollowedListResponse - (userID, username, list of users followed)
     */
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

    /**
     * Endpoint to get count of followers of a user ID
     * @param userId User ID
     * @param order Order by name (Optional - ASC or DESC)
     * @return FollowersCountUserResponse - (userID, username, count of followers)
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountUserResponse> userFollowedQuantity (@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.findUserFollowedQuantity(userId), HttpStatus.OK);
    }

    // * ============== *

    /**
     * Endpoint to get all users followers by a user ID
     * @param userId User ID
     * @param order Order by name (Optional - ASC or DESC)
     * @return UserFollowerListResponse - (userID, username, list of users followers)
     */
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

    /**
     * Endpoint to follow a user
     * @param userId User ID
     * @param userIdToFollow User ID to follow
     * @return HttpStatus - 200 OK (if success) or 400 Bad Request (if error)
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> follow (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws Throwable {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow));
    }

    // * ============== *

    /**
     * Endpoint to unfollow a user
     * @param userId User ID
     * @param userIdToUnfollow User ID to unfollow
     * @return HttpStatus - 200 OK (if success) or 400 Bad Request (if error)
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollowUser (@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws Throwable {
        return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow));
    }

}

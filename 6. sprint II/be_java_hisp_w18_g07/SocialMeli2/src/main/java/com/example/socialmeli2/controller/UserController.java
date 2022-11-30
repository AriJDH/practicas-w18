package com.example.socialmeli2.controller;

import com.example.socialmeli2.dto.response.UserFollowedListResponse;
import com.example.socialmeli2.dto.response.UserFollowerCountResponse;
import com.example.socialmeli2.dto.response.UserFollowersListResponse;
import com.example.socialmeli2.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    //US 001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUserSeller(@NotNull(message = "El  id no puede estar vacío.")
                                                 @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                 @PathVariable Integer userId,
                                                 @NotNull(message = "El  id no puede estar vacío.")
                                                 @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                 @PathVariable Integer userIdToFollow) {

        userService.followUserSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 007
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowUserSeller(@NotNull(message = "El  id no puede estar vacío.")
                                                   @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                   @PathVariable Integer userId,
                                                   @NotNull(message = "El  id no puede estar vacío.")
                                                   @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                   @PathVariable Integer userIdToUnfollow) {

        if (userService.unfollowUserSeller(userId, userIdToUnfollow)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //US 004
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListResponse> getUsersFollowed(@NotNull(message = "El  id no puede estar vacío.")
                                                                     @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                                     @PathVariable Integer userId,
                                                                     @RequestParam(defaultValue = "") String order) {

        return new ResponseEntity<>(userService.getFollowedUsersById(userId, order), HttpStatus.OK);
    }

    //US 003
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListResponse> getUsersFollowers(@NotNull(message = "El  id no puede estar vacío.")
                                                                       @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                                       @PathVariable Integer userId,
                                                                       @RequestParam(defaultValue = "") String order) {

        return new ResponseEntity<>(userService.getFollowersUsersById(userId, order), HttpStatus.OK);
    }

    //US 002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountResponse> getUserFollowersCount(@NotNull(message = "El  id no puede estar vacío.")
                                                                           @Min(value = 1, message = "El id debe ser mayor a cero.")
                                                                           @PathVariable Integer userId) {

        return new ResponseEntity<>(userService.getUserFollowersCount(userId), HttpStatus.OK);
    }

}

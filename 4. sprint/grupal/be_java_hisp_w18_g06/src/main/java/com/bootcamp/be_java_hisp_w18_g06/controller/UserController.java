package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {

            userService.followUser(userId, userIdToFollow);
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {

        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> getFollowersCount(@PathVariable int userId) {
        UserFollowersCountDTO userFollowersCountDTO = userService.getFollowersCount(userId);
        // Agregar/Aclarar en el readme que devuelve un status...
        return ResponseEntity.status(HttpStatus.OK).body(userFollowersCountDTO);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTO> getFollowedList(@PathVariable int userId) {
        UserFollowedListDTO userFollowedListDTO = userService.getFollowedList(userId);
        // Agregar/Aclarar en el readme que devuelve un status...
        return ResponseEntity.status(HttpStatus.OK).body(userFollowedListDTO);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTO> getFollowersList(@PathVariable int userId) {
        UserFollowersListDTO userFollowersListDTO = userService.getFollowersList(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userFollowersListDTO);
    }

    // Falta 008
}

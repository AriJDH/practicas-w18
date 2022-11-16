package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.valueOf(200));
    }

    @GetMapping("/users/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.unfollow(userId, userIdToFollow), HttpStatus.valueOf(200));
    }

}

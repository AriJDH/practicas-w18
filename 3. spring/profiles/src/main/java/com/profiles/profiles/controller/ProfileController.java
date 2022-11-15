package com.profiles.profiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${message.profile}")
    private String message;

    @GetMapping()
    public ResponseEntity<String> getProfile(){
        return new ResponseEntity(message, HttpStatus.OK);
    }
}

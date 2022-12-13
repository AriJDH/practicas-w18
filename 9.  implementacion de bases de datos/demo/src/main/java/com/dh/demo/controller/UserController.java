package com.dh.demo.controller;

import com.dh.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRepository repository;

    public UserController ( UserRepository repository ) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll () {
        return new ResponseEntity<>(repository.findAll(), OK);
    }

}

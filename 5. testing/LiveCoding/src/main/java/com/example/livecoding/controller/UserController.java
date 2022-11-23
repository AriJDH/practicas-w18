package com.example.livecoding.controller;

import com.example.livecoding.dto.UserDto;
import com.example.livecoding.service.IUserService;
import com.example.livecoding.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    IUserService userService;

    public UserController(UserServiceImp userServiceImp){
        this.userService = userServiceImp;
    }


    @PostMapping("/createUser")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UserDto userDto){

        return new ResponseEntity<>(this.userService.crearUsuario(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(userService.obtenerTodos(), HttpStatus.OK);
    }
}

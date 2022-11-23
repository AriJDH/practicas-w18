package com.example.livecodingtest.controller;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.service.IUserService;
import com.example.livecodingtest.service.UserServiceImp;
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

    public UserController(UserServiceImp userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.crearUsuario(userDto),HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(userService.buscarTodos(), HttpStatus.OK);
    }


}

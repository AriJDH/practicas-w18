package com.meli.be_java_hisp_w18_g9.controller;

import com.meli.be_java_hisp_w18_g9.service.IUserService;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    UserService userService = new UserService();

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> getPlatoInfoPlato(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws Throwable {
        return new ResponseEntity<>(userService.follow(userId,userIdToFollow));
    }


}

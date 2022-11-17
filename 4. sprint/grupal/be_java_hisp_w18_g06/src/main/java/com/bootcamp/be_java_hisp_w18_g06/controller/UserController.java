package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

}

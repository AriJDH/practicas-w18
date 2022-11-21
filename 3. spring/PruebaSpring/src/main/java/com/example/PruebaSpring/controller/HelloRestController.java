package com.example.PruebaSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    //Armamos nuestro endPoint


    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello " + name + " !!! ";
    }
}

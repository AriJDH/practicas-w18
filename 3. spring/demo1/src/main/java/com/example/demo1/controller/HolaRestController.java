package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
}

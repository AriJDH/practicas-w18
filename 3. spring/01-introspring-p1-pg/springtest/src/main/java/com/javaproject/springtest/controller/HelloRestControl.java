package com.javaproject.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControl {
    @GetMapping("hello/test{name}")
    public String hello(@PathVariable String name) {
        return "Eyoo, " + name + ", what that trunk do";
    }
}

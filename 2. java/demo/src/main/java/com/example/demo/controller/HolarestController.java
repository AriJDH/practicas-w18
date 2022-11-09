package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolarestController {
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola "+name+"!, bienvenido a wave 18!";
    }
}

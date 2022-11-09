package com.example.practicaspringclasevivo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name;
    }
}

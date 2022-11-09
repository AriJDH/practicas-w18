package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    @GetMapping("/hola/{name}")
    public String hola(@PathVariable String name) {
        return "Hola " + name + "!";
    }

}

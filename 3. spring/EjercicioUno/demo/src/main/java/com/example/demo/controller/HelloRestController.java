package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// En sprintboot tdo se maneja como componentes.
@RestController// Define a esta clase como un componente controllador rest
public class HelloRestController {

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name;
    }

    @GetMapping
    public String prueva2(){
        return "Hola2";
    };


}

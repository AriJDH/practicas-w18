package com.example.spring.introSpring.vivoDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {

    @GetMapping("hello/{name}")                     //hello es el nombre del método
    public String hello(@PathVariable String name){   //recibir un parámetro por path (url)
        return "Hola " + name + "!!!";
    }
}

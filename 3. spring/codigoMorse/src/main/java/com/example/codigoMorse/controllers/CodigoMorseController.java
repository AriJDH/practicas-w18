package com.example.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @GetMapping("codificar/{cadena}")
    public String hello(@PathVariable String cadena) {
        String morse[] = {".-", "-..", "-.-.", "-..", ".","..-.",};

        return morse[0];
    }
}

package com.springP2.codMorse.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {
    MorseDecoder decoder = new MorseDecoder();

    @GetMapping("/morse/{codigo}")
    public String decodificador(@PathVariable String codigo) {
        return decoder.decodificarMorse(codigo);
    }

}
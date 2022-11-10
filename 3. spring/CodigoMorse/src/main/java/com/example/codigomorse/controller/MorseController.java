package com.example.codigomorse.controller;

import com.example.codigomorse.model.TraductorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/traducirMorse/{codigo}")
    public String traducirMorse(@PathVariable String codigo){
        return TraductorMorse.traducirMorseATexto(codigo);
    }
}

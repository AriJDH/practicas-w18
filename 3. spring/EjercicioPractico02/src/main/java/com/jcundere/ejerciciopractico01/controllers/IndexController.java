package com.jcundere.ejerciciopractico01.controllers;

import com.jcundere.ejerciciopractico01.models.ConverterMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("msj/{msj}")
    public String conversorMorseToLatin(@PathVariable String msj){
        return ConverterMorse.decodificarCodigoMorse(msj);
    }

}

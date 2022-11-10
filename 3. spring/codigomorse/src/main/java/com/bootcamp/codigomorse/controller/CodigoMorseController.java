package com.bootcamp.codigomorse.controller;

import com.bootcamp.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    CodigoMorseService codigoMorseService = new CodigoMorseService();

    @GetMapping("/morse/{codigo}")
    public String morseCodigo(@PathVariable String codigo)
    {
        return codigoMorseService.traducirCodigoMorse(codigo);
    }
}

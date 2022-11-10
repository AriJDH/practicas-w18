package com.mercadolibre.morse.controller;

import com.mercadolibre.morse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    private CodigoMorseService service = new CodigoMorseService();

    @GetMapping("/morse/{codigo}")
    public String morseCodigo(@PathVariable String codigo)
     {
        return service.traducirCodigoMorse(codigo);
    }

}

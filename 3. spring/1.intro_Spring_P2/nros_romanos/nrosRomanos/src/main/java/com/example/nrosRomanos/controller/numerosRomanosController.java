package com.example.nrosRomanos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosRomanosController {

    @PostMapping("/{numero}")
    public String convertirANroRomano(@PathVariable String numero) {
        String nroRomano = null;

        switch (numero) {
            case "1":
                nroRomano = "I";
                break;
            case "2":
                nroRomano = "II";
                break;
            case "3":
                nroRomano = "III";
                break;
            case "4":
                nroRomano = "IV";
                break;
            case "5":
                nroRomano = "V";
                break;

        }
        return nroRomano;
    }
}

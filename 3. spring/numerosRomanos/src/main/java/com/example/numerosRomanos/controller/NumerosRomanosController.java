package com.example.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String aRomano(@PathVariable Integer numero){
        ArrayList<String> aDevolver = new ArrayList<>();
        int[] numerosRomanos = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 4, 3, 1};
        String[] letrasRomanas = {"M","CM","D","C","XC","L","XL","X","IX","V","I"};

        return numerosRomanos.toString();

    }
}

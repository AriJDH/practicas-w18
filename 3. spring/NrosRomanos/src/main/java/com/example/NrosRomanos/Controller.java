package com.example.NrosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/{numero}")
    public String decimalARomano(@PathVariable int numero){

        StringBuilder romanos = new StringBuilder();
        //mapa de numeros romanos
        Map<Integer, String> numerosRomanos = Map.of(
                1, "I",
                4, "IV",
                5, "V",
                9, "IX",
                10, "X",
                40, "XL",
                50, "L",
                90, "XC",
                100, "C",
                400, "CD",
                500, "D",
                900, "CM",
                1000, "M"
        );

        // numeros enteros pocibles:
        // 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // numeros romanos posibles:
        // M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I
        String[] romanosPosibles = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // no entendi muy bien como funciona esta parte, la saque de la solcucion
        for (int i = 0; i < numeros.length; i++) {
            for (; numero >= numeros[i]; numero -= numeros[i]) {
                romanos.append(romanosPosibles[i]);
            }
        }

        return romanos.toString();
    }
}

package com.example.numeros_romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/{numero}")
    public String toRoman(@PathVariable Integer numero) {

        int num;
        int[] numerosDecimales = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        String result = "";

        num = numero;

        while (num > 0){
            int i=0;
            while (num < numerosDecimales[i] && i < numerosDecimales.length){
                i++;
            }
            num -= numerosDecimales[i];
            result += numerosRomanos[i];
        }
        return result;
    }
}
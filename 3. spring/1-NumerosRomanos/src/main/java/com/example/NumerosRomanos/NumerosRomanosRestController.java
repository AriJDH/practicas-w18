package com.example.NumerosRomanos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NumerosRomanosRestController {
    @GetMapping("pasajeRomano/{numero}")
    public String pasajeRomano(@PathVariable Integer numero) {

        StringBuilder numRomanos = new StringBuilder(); //concatena cadenas de caracteres

        int [] numerosDecimales = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] nrosRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i =0; i< numerosDecimales.length; i++){
            for(;numero >= numerosDecimales[i]; numero -= numerosDecimales[i]){
                numRomanos.append(nrosRomanos[i]);
            }
        }
        return numRomanos.toString();
    }
}

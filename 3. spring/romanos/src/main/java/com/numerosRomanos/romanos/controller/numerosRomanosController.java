package com.numerosRomanos.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosRomanosController {
    @GetMapping("/romano/{numero}")
    public String convertirRomano(@PathVariable Integer numero){
        int[] numeros = {1,2,3,4,5,6,7,8,9};
        String [] romanos =  {"I","II","III","IV","V","VI","VII","VIII","IX"};
        String romano= " ";

            int d =  numero%1000;
            int c = numero%100;
            int u = numero%10;


            if(numero>= 1000){
                romano+="M";
            }
            if(d>=500){
                romano+="C";
            }
            if(c>=10){
                romano+="X";
            }
            for(int i=0;i<numeros.length;i++){
                if(u== numeros[i]){
                    romano+=romanos[i];
                }
            }

        return romano;

    }
}

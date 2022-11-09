package com.clasespring.clasespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NumerosRomanos {
    @GetMapping("/romanos/{numero}")
    public String romanos(@PathVariable int numero){
        String numeroRomano = "";
//        int numeroEntero = Integer.getInteger(numero);
        var numeroEntero = numero;

        while (numeroEntero >= 1000){
            numeroRomano = numeroRomano + "M";
            numeroEntero -= 1000;
        }
        while (numeroEntero >= 900){
            numeroRomano =  numeroRomano + "CM";
            numeroEntero -= 900;
        }
        while (numeroEntero >= 500){
            numeroRomano = numeroRomano + "D";
            numeroEntero -= 500;
        }
        while (numeroEntero >= 400){
            numeroRomano = numeroRomano + "CD";
            numeroEntero -= 400;
        }
        while (numeroEntero >= 100){
            numeroRomano = numeroRomano + "C";
            numeroEntero -= 100;
        }
        while (numeroEntero >= 90){
            numeroRomano = numeroRomano + "XC";
            numeroEntero -= 90;
        }
        while (numeroEntero >= 50){
            numeroRomano = numeroRomano + "L";
            numeroEntero -= 50;
        }
        while (numeroEntero >= 40){
            numeroRomano = numeroRomano + "XL";
            numeroEntero -= 40;
        }
        while (numeroEntero >= 10){
            numeroRomano = numeroRomano + "X";
            numeroEntero -= 10;
        }
        while (numeroEntero >= 9){
            numeroRomano = numeroRomano + "IX";
            numeroEntero -= 9;
        }
        while (numeroEntero >= 5){
            numeroRomano = numeroRomano + "V";
            numeroEntero -= 5;
        }
        while (numeroEntero >= 4){
            numeroRomano = numeroRomano + "IV";
            numeroEntero -= 4;
        }
        while (numeroEntero >= 1){
            numeroRomano = numeroRomano + "I";
            numeroEntero -= 1;
        }

        return numeroRomano;
    }

}

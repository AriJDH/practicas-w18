package com.ejercicios.RomanNumerals.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberRestController {

    @GetMapping("/{number}")
    //Pasamos por parametro el numero que queremos pasar a romano
    public String convertToRoman(@PathVariable Integer number){
        //creamos variables auxiliares
        int i, miles, centenas, decenas, unidades;
        StringBuilder romanNumber = new StringBuilder();

        //Obtenemos cada cifra del numero
        miles = number/1000;
        centenas = number / 100 % 10;
        decenas = number / 10 % 10;
        unidades = number % 10;

        //Millar
        for (i = 1; i <= miles; i++){
            romanNumber.append("M");
        }

        //Centenas
        if (centenas == 9){
            romanNumber.append("CM");
        } else if (centenas >= 5) {
            romanNumber.append("D");
            for (i = 6; i <= centenas; i++) {
                romanNumber.append("C");
            }
        } else if (centenas == 4) {
            romanNumber.append("CD");
        } else {
            for (i = 1; i <= centenas; i++) {
                romanNumber.append("C");
            }
        }

        // Decenas
        if (decenas == 9) {
            romanNumber.append("XC");
        } else if (decenas >= 5) {
            romanNumber.append("L");
            for (i = 6; i <= decenas; i++) {
                romanNumber.append("X");
            }
        } else if (decenas == 4) {
            romanNumber.append("XL");
        } else {
            for (i = 1; i <= decenas; i++) {
                romanNumber.append("X");
            }
        }

        // Unidades
        if (unidades == 9) {
            romanNumber.append("IX");
        } else if (unidades >= 5) {
            romanNumber.append("V");
            for (i = 6; i <= unidades; i++) {
                romanNumber.append("I");
            }
        } else if (unidades == 4) {
            romanNumber.append("IV");
        } else {
            for (i = 1; i <= unidades; i++) {
                romanNumber.append("I");
            }
        }
        return romanNumber.toString();
    }
}

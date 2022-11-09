package com.W18.NumerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Map;





@RestController
public class ConversorRestController {

    @GetMapping("conversor/{valor}")
    public String convertir(@PathVariable int valor){
        String resultado = "";
        String unidad[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; //Declaro un array el cual pongo los numero romano los cuales voy a usar
        String decena[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String centena[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String miles = "";
        int m;


        int n = valor;
        int resto = n;
        m = resto / 1000; //3950/1000=3
        resto = resto % 1000;  //950

        int c = resto / 100; //9
        resto = resto % 100; // 50

        int d = resto / 10; //5
        resto = resto % 10; // 0

        int u = resto;
        for (int i = 1; i <= m; i++) {
            miles += "M";
        }
        if (n >= 1000) {
            resultado = miles + centena[c] + decena[d] + unidad[u];
        } else if (n >= 100) {
            resultado = centena[c] + decena[d] + unidad[u];
        } else {
            if (n >= 10) {
                resultado = decena[d] + unidad[u];
            } else {
                resultado = unidad[n];
            }
        }
        return "El equivalente a numeros romanos es:" + resultado;
    }
}


/*
    @RestController
    public class ConversorRestController {
        @GetMapping("/{number}")
        public String toRoman(@PathVariable Integer number) {
            StringBuilder romanNumber = new StringBuilder();
            int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
            String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

            for (int i = 0; i < numbersToCompare.length; i++)
                for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                    romanNumber.append(romanNumbers[i]);

            return romanNumber.toString();
        }
    }
    */


/*
@RestController
public class HolaRestController {
    @GetMapping("hola/{name}")
    public String hello(@PathVariable String name){
        return "Holaaaa " + name;
    }
 */
package com.example.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertirARomanoController {
    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable Integer numero){

        //Descomposición del numero decimal
        int millar = numero/1000;
        int centena = (numero%1000)/100;
        int decena = ((numero%1000)%100)/10;
        int unidad = (((numero%1000)%100)%10);
        String rmillar = "";
        String rcentena = "";
        String rdecena = "";
        String runidad ="";

        switch (millar){
            case 1:
                rmillar = "M";
                break;
            case 2:
                rmillar="MM";
                break;
            case 3:
                rmillar="MMM";
                break;
        }

        switch (centena){
            case 1:
                rcentena = "C";
                break;
            case 2:
                rcentena="CC";
                break;
            case 3:
                rcentena="CCC";
                break;
            case 4:
                rcentena="CD";
                break;
            case 5:
                rcentena="D";
                break;
            case 6:
                rcentena="DC";
                break;
            case 7:
                rcentena="DCC";
                break;
            case 8:
                rcentena="DCCC";
                break;
            case 9:
                rcentena="CM";
                break;
        }

        switch (decena){
            case 1:
                rdecena="X";
                break;
            case 2:
                rdecena="XX";
                break;
            case 3:
                rdecena="XXX";
                break;
            case 4:
                rdecena="XL";
                break;
            case 5:
                rdecena ="L";
                break;
            case 6:
                rdecena="LX";
                break;
            case 7:
                rdecena="LXX";
                break;
            case 8:
                rdecena="LXXX";
                break;
            case 9:
                rdecena="XC";
                break;
        }
        switch (unidad){
            case 1:
                runidad="I";
                break;
            case 2:
                runidad="II";
                break;
            case 3:
                runidad="III";
                break;
            case 4:
                runidad="IV";
                break;
            case 5:
                runidad="V";
                break;
            case 6:
                runidad="VI";
                break;
            case 7:
                runidad="VII";
                break;
            case 8:
                runidad="VIII";
                break;
            case 9:
                runidad="IX";
                break;
        }
        //Solución válida para números entre 1 y 3999
        return "El número decimal "+numero+" convertido a número romano es: "+rmillar+rcentena+rdecena+runidad;

        /*int[] decimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
        String[] conversion = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder romanos = new StringBuilder();

        int num = numero;
        for (int i = 0; i < decimales.length; i++) {
            while (num >= decimales[i]){
                num = num - decimales[i];
                romanos.append(conversion[i]);
            }
        }
        //Solución válida para números entre 1 y 3999
        return "El número decimal "+numero+" convertido a número romano es: "+romanos.toString();*/
    }
}

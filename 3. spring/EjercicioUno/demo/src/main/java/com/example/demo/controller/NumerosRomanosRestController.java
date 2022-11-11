package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NumerosRomanosRestController {

    //ResolucionGasty
    @GetMapping("numero/Romano/{numero}")
    public String getNumeroRomano(@PathVariable Integer numero){
        if (numero > 3999)
            return "Escribr un numero menor  a 4000";

        int num = numero;
        String rom = "";

        //Millar
        int mi=numero/1000;
        numero=numero%1000;

        //Centena
        int ce=numero/100;
        numero=numero%100;

        //Decena
        int de=numero/10;
        numero=numero%10;

        //Unidad
        int un=numero/1;
        
        //1 al 9 en Romano
        switch (numero) {
            case 1:
                rom="I";
                break;
            case 2:
                rom="II";
                break;
            case 3:
                rom="III";
                break;
            case 4:
                rom="IV";
                break;
            case 5:
                rom="V";
                break;
            case 6:
                rom="VI";
                break;
            case 7:
                rom="VII";
                break;
            case 8:
                rom="VIII";
                break;
            case 9:
                rom="IX";
                break;
        }

        //10 al 99 en Romano
        switch (de) {
            case 1:
                rom="X"+rom;
                break;
            case 2:
                rom="XX"+rom;
                break;
            case 3:
                rom="XXX"+rom;
                break;
            case 4:
                rom="XL"+rom;
                break;
            case 5:
                rom="L"+rom;
                break;
            case 6:
                rom="LX"+rom;
                break;
            case 7:
                rom="LXX"+rom;
                break;
            case 8:
                rom="LXXX"+rom;
                break;
            case 9:
                rom="XC"+rom;
                break;
        }

        //100 al 999 en Romano
        switch (ce) {
            case 1:
                rom="C"+rom;
                break;
            case 2:
                rom="CC"+rom;
                break;
            case 3:
                rom="CCC"+rom;
                break;
            case 4:
                rom="CD"+rom;
                break;
            case 5:
                rom="D"+rom;
                break;
            case 6:
                rom="DC"+rom;
                break;
            case 7:
                rom="DCC"+rom;
                break;
            case 8:
                rom="DCCC"+rom;
                break;
            case 9:
                rom="CM"+rom;
                break;
        }

        //1000 al 3999 en Romano
        switch (mi) {
            case 1:
                rom="M"+rom;
                break;
            case 2:
                rom="MM"+rom;
                break;
            case 3:
                rom="MMM"+rom;
        }

        return "El numero " + num + " en romano es: " + rom;
    };

    //Resolucion profeVariante (ajustar)
    @GetMapping("numero/Romano2/{numero}")
        public String getNumero2(@PathVariable Integer numero){

        int numeroOriginal = numero;
        StringBuilder numeroRomano = new StringBuilder();

        int numeros[] = new int[]{1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomanos = new String[]{"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        //Va restando y va creando el numero remano
        for (int i = 0;i < numeros.length; i++){
            while (numero >= numeros[i]){
                numero -= numeros[1];
                numeroRomano.append(numerosRomanos[i]);
            }
        };

        return "El numero " + numeroOriginal + " en romano es : " + numeroRomano.toString();
    }

    //Resolucion Profes
    @GetMapping("numero/Romano3/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }

};

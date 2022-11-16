package com.example.primerProyecto.controller;

import java.util.Arrays;

public class NumerosRomanos {

    public NumerosRomanos() {
    }


    public String generarNumeroRomano(Integer numero) {
        String romanos[] = {"I", "V", "X", "L", "C", "D", "M", "-V"};
        int numeros[] = {1, 5, 10, 50, 100, 500, 1000, 5000};

        String convertidor = "";
        int indice = 6;
        int i = 7;

        while (numero > 0){

            if (numeros[i] - numeros[indice] <= numero && numero < numeros[i]){
                convertidor = convertidor + romanos[indice] + romanos[i];
                numero = numero - (numeros[i] - numeros[indice]);
            }

            if (numero - numeros[i] >= numeros[indice]){
                numero = numero - numeros[i];
                convertidor = convertidor + romanos[i];
                int division = (int) ((numero)/numeros[indice]);
                for(int j = 1; j<= division; j++){
                    convertidor = convertidor + romanos[indice];
                    numero = numero - numeros[indice];
                }

            }

            if (numero > numeros[i]) {
                convertidor = convertidor + romanos[i];
                numero = numero - numeros[i];
            }

            if (numero == numeros[i]) {
                convertidor = convertidor + romanos[i];
                numero = numero - numeros[i];
            }

            i--;
            if(numero <= numeros[indice]){
                indice = indice -2;
            }

        }
        return convertidor;
    }


}

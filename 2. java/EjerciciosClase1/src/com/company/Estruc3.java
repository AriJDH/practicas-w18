package com.company;

import java.util.Scanner;

public class Estruc3 {
    public static void main(String[] args) {

        int num = 2;
        String mensaje;

        switch (num){
            case 1: mensaje = "Aprobado";
                break;
            case 2: mensaje = "Desaprobado";
                break;
            case 3: mensaje = "Diciembre";
                break;
            default: mensaje = "Incorrecto";
                break;


        }
        System.out.println(mensaje);
    }
}

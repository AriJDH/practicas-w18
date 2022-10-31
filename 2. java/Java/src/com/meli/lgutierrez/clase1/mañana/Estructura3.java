package com.meli.lgutierrez.clase1.mañana;

public class Estructura3 {
    public static void main(String[] args) {
        int tipoResult = 1;
        String mensaje;

        switch (tipoResult){
            case 1 : mensaje = "Aprobado";
                break;
            case 2 : mensaje = "Desaprobado";
                break;
            case 3 : mensaje = "Diciembre";
                break;

            default: mensaje = "No se presentó";
                break;
        }
        System.out.println(mensaje);
    }
}

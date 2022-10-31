package com.meli.lgutierrez.clase1.mañana;

public class Estructura1 {
    static final int INCENTIVO = 21000;
    public static void main(String[] args) {

        int ventas = 21000;
        int objetivo = 20000;

        if (ventas > objetivo){
            System.out.println("Satisfactoria " + INCENTIVO);
        } else{
            System.out.println("No llegó a objetivo.");
        }
    }
}

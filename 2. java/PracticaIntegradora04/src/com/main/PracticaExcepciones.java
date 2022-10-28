package com.main;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    /*public void calcular(){

        int result = 0;

        try {
            result = b / a;
        } catch (Exception e) {

            System.out.println("Se ha Producido un ERROR !");
        } finally {

            System.out.println("El programa ha finalizado !");
        }*/

    public void calcular(){

        int result = 0;

        try {
            result = b / a;
        } catch (Exception e) {

            throw new IllegalArgumentException("No se puede dividir por Cero");

        } finally {

            System.out.println("El programa ha finalizado !");
        }
    }
}

package com.company;

public class PracticaExcepciones {

    static int  a=0;
    static int b=300;

    public static void main(String[] args) {
        try{
            int cociente = b/a;
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}

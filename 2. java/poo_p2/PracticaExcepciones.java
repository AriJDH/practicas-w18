package com.example.poo_p2;

public class PracticaExcepciones {
    public int a =0;
    public int b =300;
    public PracticaExcepciones(){}

    public float cociente(){
        try{
          return this.b/this.a;
        }catch(ArithmeticException e){
           throw new IllegalArgumentException("No se puede dividir por cero");


        }finally {
            System.out.println("Programa finalizado");
        }
    }
}




package Ejercicio1;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;


    public void calcular(){

        try{
            int result = this.b / this.a;
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
    }

}

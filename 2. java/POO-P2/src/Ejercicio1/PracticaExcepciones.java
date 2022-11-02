package Ejercicio1;
//EJERCICIO 1

public class PracticaExcepciones {
    private int a=0;
    private int b=300;

    // 1.
    /*public void calcular(){
        try{
            double resultado=b/a;
        }
        catch (ArithmeticException exception){
            System.out.println("Se ha producido un error. "+exception.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }*/

    // 2.
    public void calcular(){
        try {
            if (a==0)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException exception){
            System.out.println("No se puede dividir por cero. "+exception.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}

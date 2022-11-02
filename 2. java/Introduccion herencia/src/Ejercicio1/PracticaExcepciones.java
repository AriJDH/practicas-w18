package Ejercicio1;

public class PracticaExcepciones {

    public static void division(int a, int b) {
        double cociente;
        try {
            cociente = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally{
            System.out.println("Programa finalizado");
        }
    }
    public static void division2(int a, int b){
        double cociente;
        try {
            if (a==0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones.division(0,300);
        PracticaExcepciones.division2(0,300);
    }
}
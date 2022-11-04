package Poo;

public class Main {
    public static void main(String[] args) {
        PracticaExepciones practicaExepciones = new PracticaExepciones();
        try{ practicaExepciones.CalcularCociente();
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}

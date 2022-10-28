package Excepciones;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0) {
                throw new IllegalArgumentException("no se puede dividir por cero");
            }
            int cociente = b/a;
        } catch(ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("fin del programa");
        }
    }
}

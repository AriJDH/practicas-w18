package Clase2;

public class mainExcepciones {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        try{
            int a = practicaExcepciones.getA();
            int b = practicaExcepciones.getB();
            if (a ==0 ) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            int res = b / a;
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}

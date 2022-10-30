package excepciones;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int calcularCociente() {
        try {
            int cociente = b/a;
            return cociente;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

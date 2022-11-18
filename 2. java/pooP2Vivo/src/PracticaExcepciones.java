public class PracticaExcepciones {
    private int a=0;
    private int b=300;

    public void calcularCociente() {
        try {
            System.out.println(b / a);
        } catch (ArithmeticException ex) {
            //System.out.println("Se ha producido un error");
            System.out.println(new IllegalArgumentException("No se puede dividir por cero"));

        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

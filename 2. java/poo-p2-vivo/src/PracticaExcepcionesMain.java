public class PracticaExcepcionesMain {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        try {
            System.out.println("Hello world!" + practicaExcepciones.cociente());
        } catch (ArithmeticException exception) {
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
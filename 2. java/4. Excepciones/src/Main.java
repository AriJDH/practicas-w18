public class Main {

    public static void main(String[] args) {

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.calcular();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(("Se ha producido un error"));
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}

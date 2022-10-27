package ejercicio_poo_p2_vivo.ejercicio1;

public class PracticaExcepciones {

    private static int a = 0;

    private static int b = 300;

    public static void main(String[] args) {

        try {
            int conciente = b/a;

        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

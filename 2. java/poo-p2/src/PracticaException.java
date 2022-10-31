public class PracticaException {
    /*
    Ejercicio 1
Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
“Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje
“Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje
“No se puede dividir por cero”
*/
    private int a = 0;
    private int b = 300;

    public int cocinetAB(int a, int b) throws IllegalAccessException {
        int result = 0;
        try {
            result = b * a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw new IllegalAccessException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }
}

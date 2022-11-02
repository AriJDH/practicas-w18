package logica;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void coeficiente(){
        try{
            int coeficiente = b/a;
        } catch (ArithmeticException ex){
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

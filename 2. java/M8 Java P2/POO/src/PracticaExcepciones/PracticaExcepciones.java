package PracticaExcepciones;

/*Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
 Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
 “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”*/

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;
    private int resultado;

    public PracticaExcepciones(){}

    public void cociente(){
        try{
            resultado = this.b/this.a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
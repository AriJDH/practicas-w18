package ejercicio1;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public PracticaExcepciones() {
        //No args constructor
    }

    public int cociente(){
        try{
            return this.b / this.a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}

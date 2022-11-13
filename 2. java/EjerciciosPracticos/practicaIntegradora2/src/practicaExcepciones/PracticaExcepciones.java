package practicaExcepciones;

public class PracticaExcepciones {

    private int a ;
    private int b=300;

    public void cociente(){
        try {
            float result =this.b/this.a;
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero. ");
        }finally {
            System.out.println("Programa finalizado.");
        }
    }
}

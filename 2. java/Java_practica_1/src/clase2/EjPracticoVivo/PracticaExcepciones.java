package clase2.EjPracticoVivo;

public class PracticaExcepciones {
    public int a = 0;
    public int b = 300;

    /*public void division() {
        try {
            double c = b / a;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally{
            System.out.println("Programa finalizado");
        }
    }*/

    public void division() {
        try {
            if( a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            double c = b / a;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage() + " y algo más!");
        }finally{
            System.out.println("Programa finalizado");
        }
    }
}

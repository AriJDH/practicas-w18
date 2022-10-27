package PracticoExcepciones;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        parte1();
        parte2();
    }

    public static void parte2(){
        try{
            int res = PracticaExcepciones.b / PracticaExcepciones.a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir entre 0.");
        }finally{
            System.out.println("Programa finalizado.");
        }
    }

    public static void parte1(){
        try{
            int res = PracticaExcepciones.b / PracticaExcepciones.a;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error.");
        }finally{
            System.out.println("Programa finalizado.");
        }
    }

}

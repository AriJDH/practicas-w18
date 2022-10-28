public class PracticaExcepciones{
    private int a = 0;
    private int b = 300;

    public void calculaCociente(){
        try{
            int resultado = b/a;
            System.out.println("El resultado es: "+ resultado);
        }catch (ArithmeticException e){
            System.out.println("ERROR: " + e.getMessage() + "\n" + "Error no se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
    public static void main(String [] args){
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.calculaCociente();
    }
}


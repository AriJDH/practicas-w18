import java.util.Scanner;

public class PracticaExcepciones{

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void calculaCociente(){
        try{
            if(a == 0){
                throw new IllegalArgumentException();
            }
            int resultado = b/a;
            System.out.println("El resultado es: "+ resultado);
        }catch (IllegalArgumentException x){
            System.out.println("--- No se puede dividir entre 0 ---");
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
    public static void main(String [] args){
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese valor de A: ");
        practicaExcepciones.setA(in.nextInt());
        System.out.print("Ingrese valor de B: ");
        practicaExcepciones.setB(in.nextInt());
        practicaExcepciones.calculaCociente();
    }
}

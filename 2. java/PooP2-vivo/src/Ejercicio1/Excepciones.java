package Ejercicio1;

public class Excepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try {
            if(a == 0) throw new IllegalArgumentException("No se puede dividir por cero");

            System.out.println(b/a);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}

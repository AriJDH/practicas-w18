package clase1;
import java.util.Scanner;

public class Arreglos {
    private Scanner teclado;
    private int[] sueldos;

    public void cargar(){
        teclado = new Scanner(System.in);
        sueldos = new int[5];
        for(int i=0; i<5; i++){
            System.out.println("Ingrese el valor: ");
            sueldos[i] = teclado.nextInt();
        }
    }

    public void imprimir(){
        for(int j=0; j<5; j++){
            System.out.println(sueldos[j]);
        }
    }

    public static void main(String[] args) {
        Arreglos arr = new Arreglos(); // creo el objeto
        arr.cargar();
        arr.imprimir();
    }
}






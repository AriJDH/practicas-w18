import java.util.Scanner;

public class Arreglo {
    private Scanner teclado;
    private int[] sueldos;

    public void cargar(){
        teclado = new Scanner(System.in);
        sueldos = new int[5];
        for (int i=0; i<5; i++){
            System.out.println("Ingrese el valor: ");
            sueldos[i] = teclado.nextInt();
        }
        teclado.close();
    }

    public void imprimir(){
        for (int i=0; i<5; i++){
            System.out.println(sueldos[i]);
        }

    }
    public static void main(String[] args) {
        Arreglo arr = new Arreglo();
        arr.cargar();
        arr.imprimir();
    }
}

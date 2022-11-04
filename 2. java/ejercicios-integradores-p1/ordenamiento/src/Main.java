import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el numero de elementos");
        int numeroElementos = Integer.parseInt(entrada.nextLine());
        int [] arreglo = new int [numeroElementos];
        for(int i = 0; i<numeroElementos; i++){
            System.out.println( "Ingrese numero: "+ (i+1));
            arreglo[i] = Integer.parseInt(entrada.nextLine());
        }

        int aux =0;
        for(int i = 0; i<arreglo.length-1; i++){
            for( int j = 0; j< arreglo.length-1; j++){
                if(arreglo[j]>arreglo[j+1]){
                    aux =arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }
        System.out.println("Se muestra la lista ordenada ascedentemente: ");
        for (int i :arreglo) {
            System.out.println(i);
        }
    }
}
package Burbuja;

import java.util.Arrays;

public class Burbuja {

    public static int[] burbuja(int[] array) {
        int aux;
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j+1] < array[j]){
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }

        }

        return array;
    }

    public static void main(String[] args) {
        int[] arreglo = {5,2,1,3,4};

        arreglo = burbuja(arreglo);

        Arrays.stream(arreglo).forEach(System.out::println);
    }

}

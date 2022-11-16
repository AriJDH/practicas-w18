package com.meli.lgutierrez.clase4.tarde.ejerciciosPracticos;


import java.util.Arrays;

public class EjAlgoritmoOrdenamiento {

    public static int[] burbuja(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 2, 3};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(burbuja(array)));
    }


}

package com.company;

public class ExP1 {

    private String[] ciudades;
    private int[][] temperaturas;
    public int min, max;

    public String city_min, city_max;

    public void cargar(){
        ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Stgo de Chile", "Lisboa", "Tokio"};
        temperaturas = new int[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };
    }

    public void getMinMax(){
        min = 99;
        max = 0;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2; j++){
                if (temperaturas[i][j] < min){
                    min = temperaturas[i][j];
                    city_min = ciudades[i];
                }
                if (temperaturas[i][j] > max){
                    max = temperaturas[i][j];
                    city_max = ciudades[i];
                }
            }
        }

        System.out.println("La ciudad con la menor temperatura fue " + city_min + " con " + min + " grados");
        System.out.println("La ciudad con la mayor temperatura fue " + city_max + " con " + max + " grados");
    }

    public static void main(String[] args) {
        ExP1 exp1 = new ExP1();
        exp1.cargar();
        exp1.getMinMax();
    }

}

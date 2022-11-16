package Ejercicio_temp;

import java.net.StandardSocketOptions;

public class Temperatura {
    private String[] ciudades;
    private int[][] temperaturas;
    int max,min;
    String maxCity, minCity;

    public void cargar(){
        ciudades = new String[10];
        temperaturas = new int[10][2];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "New York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[0][0] = 0;
        temperaturas[0][1] = 39;
    }

    public void comparar(){
        max = -199;
        min = 100;
        for (int i = 0 ; i<10 ; i++) {
            if (temperaturas[i][0] < min) {
                min = temperaturas[i][0];
                minCity = ciudades[i];
            }
            if (temperaturas[i][1] > max) {
                max = temperaturas[i][1];
                maxCity = ciudades[i];
            }
        }
    }

    public void retornar(){
        System.out.println("La menor temperatura la tuvo " + minCity + ", con " + min + "ºC");
        System.out.println("La mayor temperatura la tuvo " + maxCity + ", con " + max + "ºC");
    }

    public static void main(String[] args) {
        Temperatura temp = new Temperatura();
        temp.cargar();
        temp.comparar();
        temp.retornar();
    }
}

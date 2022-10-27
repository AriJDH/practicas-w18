package com.main;

import java.util.Scanner;

public class App {

    private String[] ciudades;
    private int[][] temperaturas;

    public static void main(String[] args) {

        App app = new App();

        app.cargarDatosDefault();
        app.calcularTemperaturaMinima(app.getTemperaturas(), app.getCiudades());
        app.calcularTemperaturaMaxima(app.getTemperaturas(), app.getCiudades());

        System.out.println(" ");

        app.cargarDatosScanner();
        app.calcularTemperaturaMinima(app.getTemperaturas(), app.getCiudades());
        app.calcularTemperaturaMaxima(app.getTemperaturas(), app.getCiudades());
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public void setCiudades(String[] ciudades) {
        this.ciudades = ciudades;
    }

    public int[][] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(int[][] temperaturas) {
        this.temperaturas = temperaturas;
    }

    public void cargarDatosDefault() {

        ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas = new int[10][2];

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
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

    }

    public void cargarDatosScanner() {

        Scanner in = new Scanner(System.in);

        ciudades = new String[10];
        temperaturas = new int[10][2];

        for (int i = 0; i < ciudades.length; i++) {
            System.out.print("Ingrese la Ciudad " + (i+1) + " de " + ciudades.length + ": ");
            ciudades[i] = in.nextLine();

            System.out.print("Ingrese la temperatura minima: ");
            temperaturas[i][0] = Integer.parseInt(in.nextLine());
            System.out.print("Ingrese la temperatura maxima: ");
            temperaturas[i][1] = Integer.parseInt(in.nextLine());

        }
    }

    public void calcularTemperaturaMinima(int[][] temperaturas, String[] ciudades){

        String cityResult = "N/A";
        int tempResult = 999;
        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i][0] < tempResult){
                cityResult = ciudades[i];
                tempResult = temperaturas[i][0];
            }
        }
        System.out.println("La temperatura minima es: " + tempResult + " registrada en: " + cityResult);

    }

    public void calcularTemperaturaMaxima(int[][] temperaturas, String[] ciudades){

        String cityResult = "N/A";
        int tempResult = -999;
        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i][1] > tempResult){
                cityResult = ciudades[i];
                tempResult = temperaturas[i][1];
            }
        }
        System.out.println("La temperatura maxima es: " + tempResult + " registrada en: " + cityResult);

    }

}
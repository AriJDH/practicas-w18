package temperaturas;

import java.util.Scanner;

public class App {
    static final int CANTIDAD_CIUDADES = 10;
    String[] ciudades = new String[CANTIDAD_CIUDADES];
    int[][] temperaturas = new int[CANTIDAD_CIUDADES][2];
    int maximaGlobal = Integer.MIN_VALUE;
    int minimaGlobal = Integer.MAX_VALUE;
    int indiceCiudadMaxima, indiceCiudadMinima;
    Scanner input;

    public void cargarCiudadesYTemperaturas(){
        input = new Scanner(System.in);
        for (int i = 0; i< ciudades.length; i++) {
            System.out.println("Ingrese ciudad "+ (i+1) +":");
            ciudades[i] = input.nextLine();
            System.out.println("Ingrese la temperatura mín de " + ciudades[i] + ":");
            temperaturas[i][0] = input.nextInt();
            System.out.println("Ingrese la temperatura max de " + ciudades[i] + ":");
            temperaturas[i][1] = input.nextInt();
            input.nextLine();
        }
        input.close();
    }

    public void hallarTemperaturaMaxYMin(){
        for (int i = 0; i< temperaturas.length; i++) {
            for (int j = 0; j< temperaturas[0].length; j++){
                int auxTemp = temperaturas[i][j];
                if (auxTemp > maximaGlobal) {
                    maximaGlobal = auxTemp;
                    indiceCiudadMaxima = i;
                }
                if (auxTemp < minimaGlobal) {
                    minimaGlobal = auxTemp;
                    indiceCiudadMinima = i;
                }
            }
        }
    }

    public void imprimirMaximasYMinimasGlobales(){
        System.out.println("La ciudad que tuvo la menor temperatura fue " + ciudades[indiceCiudadMinima]+ ", con "+ minimaGlobal+ "ºC");
        System.out.println("La ciudad que tuvo la mayor temperatura fue " + ciudades[indiceCiudadMaxima]+ ", con "+ maximaGlobal+ "ºC");
    }


    public static void main(String[] args) {
        App temperaturasApp = new App();
        temperaturasApp.cargarCiudadesYTemperaturas();
        temperaturasApp.hallarTemperaturaMaxYMin();
        temperaturasApp.imprimirMaximasYMinimasGlobales();
    }

}

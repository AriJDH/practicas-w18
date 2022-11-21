package IntroAJavaP1Vivo;

import java.util.Scanner;

public class AppTemperatura {
    Scanner input = new Scanner(System.in);
    int size, tempMax, tempMin;
    int indexMax = 0;
    int indexMin = 0;
    String ciudades[] = definirCantidadDeCiudades();
    int temperaturas[][] = definirMatrizTemperaturas(size);


    public String[] definirCantidadDeCiudades() {
        System.out.println("ingrese la cantidad de ciudades a cargar");
        size = input.nextInt();
        input.nextLine();
        String ciudades[] = new String[size];
        return ciudades;
    }

    public int[][] definirMatrizTemperaturas(int size) {
        int temperaturas[][] = new int[size][2];
        return temperaturas;
    }

    public void cargarCiudadesYTemperaturas() {
        // Cargar cidades y Temperaturas de cada ciudad
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingrese el nombre de la ciudad: ");
            ciudades[i] = input.nextLine();
            System.out.println("Ingrese la temperatura minima de esa ciudad: ");
            temperaturas[i][0] = input.nextInt();
            System.out.println("Ingrese la temperatura máxima de esa ciudad: ");
            temperaturas[i][1] = input.nextInt();
            input.nextLine();
        }
    }

    public void obtenerTempMinYMax() {

        // comparar temperaturas minimas
        for (int i = 0; i < size; i++) {
            if (tempMin >= temperaturas[i][0]) {
                tempMin = temperaturas[i][0];
                indexMin = i;
            }
            if (tempMax <= temperaturas[i][1]) {
                tempMax = temperaturas[i][1];
                indexMax = i;
            }
        }
    }

    public void mostrarCiudadConMinYMaxTemp() {
        // Mostrar por consola los resultados
        System.out.println("La ciudad de " + ciudades[indexMin] + " tiene una temperatura de " + temperaturas[indexMin][0] +
                " ºC siendo la mas baja de todas las ciudades");
        System.out.println("La ciudad de " + ciudades[indexMax] + " tiene una temperatura de " + temperaturas[indexMax][1] +
                " ºC siendo la mas alta de todas las ciudades");
    }

    public static void main(String[] args) {
    AppTemperatura temperaturasMaxYMin = new AppTemperatura();
    //temperaturasMaxYMin.definirCantidadDeCiudades();
    temperaturasMaxYMin.cargarCiudadesYTemperaturas();
    temperaturasMaxYMin.obtenerTempMinYMax();
    temperaturasMaxYMin.mostrarCiudadConMinYMaxTemp();
    }
}

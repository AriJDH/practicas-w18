package clase1;

import java.util.Scanner;

public class Ejercicio1Vivo {
    private final String[] Ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    private final int[][] Temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 27}, {6, 42}, {5, 43},{0, 39},{-7, 26},{-1, 31}, {-10, 35}};

    public void obtenerTemperaturasCiudad(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese nombre de ciudad a obtener temperaturas.");
        String ciudad = teclado.nextLine();
        int indiceCiudad = obtenerIndiceCiudad(ciudad);

        if(indiceCiudad<0 || indiceCiudad >= Temperaturas.length){
            System.out.println("ERROR! Ciudad no encontrada.");
        }else{
            System.out.println("Temperatura mínima "+ciudad + ": "+ Temperaturas[indiceCiudad][0]);
            System.out.println("Temperatura máxima "+ciudad + ": "+ Temperaturas[indiceCiudad][1]);
        }

    }

    public void mostrarCiudadConMinima(){
        int indice = obtenerIndiceTemperaturaMasBaja();
        System.out.println("La temperatura mas baja está en " + Ciudades[indice] + " y es de: "+ Temperaturas[indice][0]);
    }

    public void mostrarCiudadConMaxima(){
        int indice = obtenerIndiceTemperaturaMasAlta();
        System.out.println("La temperatura mas alta está en " + Ciudades[indice] + " y es de: "+ Temperaturas[indice][1]);
    }

    private int obtenerIndiceCiudad(String ciudad){
        int indice = -1;
        for(int i = 0; i< Ciudades.length; i++){
            if(Ciudades[i].equals(ciudad))indice = i;
        }
        return indice;
    }

    private int obtenerIndiceTemperaturaMasBaja(){
        //int masBaja = Integer.MAX_VALUE;
        int indiceMasBaja = 0;
        int indiceActual = 0;

        while(indiceActual < Temperaturas.length){
            if(Temperaturas[indiceActual][0] < Temperaturas[indiceMasBaja][0])indiceMasBaja = indiceActual;
            indiceActual++;
        }

        return indiceMasBaja;
    }

    private int obtenerIndiceTemperaturaMasAlta(){
        //int masBaja = Integer.MAX_VALUE;
        int indiceMasAlta = 0;
        int indiceActual = 0;

        while(indiceActual < Temperaturas.length){
            if(Temperaturas[indiceActual][1] > Temperaturas[indiceMasAlta][1])indiceMasAlta = indiceActual;
            indiceActual++;
        }

        return indiceMasAlta;
    }
}

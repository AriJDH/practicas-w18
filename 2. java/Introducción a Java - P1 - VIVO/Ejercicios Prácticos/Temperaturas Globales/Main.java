import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaracion de variables y estructuras:

        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];

        int tempMax = 0;
        int tempMin = 0;
        int posMax = 0;
        int posMin = 0;

        Scanner entrada = new Scanner(System.in);

        //Carga de datos recorriendo cada array:


       System.out.println("Introduzca las ciudades:");
       for(int i=0; i< ciudades.length; i++){
           ciudades[i] = entrada.nextLine();
       }

        System.out.println("Introduzca las temperaturas:");
        for(int i=0; i< temperaturas.length; i++){
            for(int j=0; j< 2; j++){
                temperaturas[i][j] = entrada.nextInt();
            }
        }

        
        //Se realiza la logica para resolver el problema:

        for(int i=0; i< temperaturas.length; i++){
            for(int j=0; j<2; j++){

                if(tempMax > temperaturas[i][j]){

                    tempMax = temperaturas[i][j];
                    posMax = i;

                }

                if(tempMin < temperaturas[i][j]){

                    tempMin = temperaturas[i][j];
                    posMin = i;
                }

            }
        }

        //Resultado Final
        System.out.println("La ciudad con mayor temperatura es: " + ciudades[posMax] + " con una temperatura de: " + tempMax + "ºC");
        System.out.println("La ciudad con menor temperatura es: " + ciudades[posMin] + " con una temperatura de: " + tempMin + "ºC");

    }
}
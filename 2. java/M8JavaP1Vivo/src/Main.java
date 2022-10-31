import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Variables del sistema
        String ciudades[] = new String[10];
        Integer temperaturas[][]= new Integer[10][10];
        Integer temperaturaMin, temperaturaMax;
        String ciudadMin, ciudadMax;

        // Scanner
        final Scanner input = new Scanner(System.in);

        // Ingreso de ciudades
        System.out.println("A continuación ingrese los datos de las ciudades y sus temperaturas máximas y mínimas: ");

        for (int i = 0; i <= 9 ; i++) {
            System.out.println("Ingrese ciudad: ");
            ciudades[i] = input.nextLine();
            for (int j = 0; j <= 1 ; j++) {
                if(j==0) {
                    System.out.println("Ingrese temperatura mínima de la ciudad " + ciudades[i]);
                    temperaturas[i][j] = Integer.valueOf(input.nextLine());
                } else {
                    System.out.println("Ingrese temperatura máxima de la ciudad " + ciudades[i]);
                    temperaturas[i][j] = Integer.valueOf(input.nextLine());
                }
            }

        }

        //Buscamos las temperaturas máx. y mín.
        temperaturaMin = temperaturas[0][0];
        temperaturaMax = temperaturas[0][0];
        ciudadMin = ciudades[0];
        ciudadMax = ciudades[0];

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 1 ; j++) {
                // Guardamos la temperatura mínima
                if(temperaturas[i][j] < temperaturaMin){
                    temperaturaMin = temperaturas[i][j];
                    ciudadMin = ciudades[i];
                }

                // Guardamos la temperatura máxima
                if(temperaturas[i][j] > temperaturaMax){
                    temperaturaMax = temperaturas[i][j];
                    ciudadMax = ciudades[i];
                }
            }
        }
        System.out.println("La ciudad de " + ciudadMin + " es la ciudad con la temperatura mínima de: " + temperaturaMin);
        System.out.println("La ciudad de " + ciudadMax + " es la ciudad con la temperatura máxima de: " + temperaturaMax);
    }
}
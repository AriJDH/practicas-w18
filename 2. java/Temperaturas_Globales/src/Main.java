import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];
        Scanner ingresar = new Scanner(System.in);
        int tempMAX = -9999999;
        int tempMIN = 99999999;
        int indiceCiudadMIN = 0;
        int indiceCiudadMAX = 0;

        //Cargo las ciudades
        System.out.println("Ingrese los nombres de las ciudades: ");
        for (int i=0;i<10;i++){
            ciudades[i]=ingresar.nextLine();
        }


        System.out.println("====================================");
        System.out.println("====================================");
        System.out.println("====================================");
        //Cargo las temperaturas para la ciudades
        for (int i=0;i<10;i++){
            System.out.println("Ingrese la temperatura para la ciudad " + ciudades[i] + ": ");
            for (int j=0;j<1;j++) {
                System.out.println("Minimo: ");
                temperaturas[i][j] = ingresar.nextInt();
                if (temperaturas[i][j] < tempMIN) {
                    tempMIN = temperaturas[i][j];
                    indiceCiudadMIN = i;

                }
                System.out.println("Maximo: ");
                temperaturas[i][j] = ingresar.nextInt();
                if (temperaturas[i][j] > tempMAX) {
                    tempMAX = temperaturas[i][j];
                    indiceCiudadMAX = i;
                }
            }

        }

        System.out.println("====================================");
        System.out.println("====================================");
        System.out.println("====================================");

        //Muestro los resultados
        System.out.println("La ciudad con mas fria con " + tempMIN + " es: " + ciudades[indiceCiudadMIN] );
        System.out.println("La ciudad con mas calurosa con " + tempMAX + " es: " + ciudades[indiceCiudadMAX] );



    }
}
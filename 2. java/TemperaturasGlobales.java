import java.util.Scanner;

public class TemperaturasGlobales {

    public static void main(String[] args) {

        System.out.println("Ingrese los nombres de las ciudades y sus temperaturas (10 ciudades)");

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        String ciudades[] = new String[10];
        double temperaturas[][] = new double[10][2];

        // carga de datos
        for(int i = 0; i < 10; i++)
        {
            System.out.println("ingrese una ciudad: ");
            ciudades[i] = input.nextLine();

            System.out.println("ingrese su temperatura minima: ");
            temperaturas[i][0] = input2.nextInt();

            System.out.println("ingrese su temperatura maxima: ");
            temperaturas[i][1] = input2.nextInt();
        }

        // calculo de minimos y maximos

        double minTemp, maxTemp;
        String minCiu, maxCiu;

        minTemp = maxTemp = temperaturas[0][0];
        minCiu = maxCiu = ciudades[0];

        for(int i = 0; i < 10; i++)
        {
            if(minTemp > temperaturas[i][0])
            {
                minTemp = temperaturas[i][0];
                minCiu = ciudades[i];
            }
            if(maxTemp < temperaturas[i][1]){
                maxTemp = temperaturas[i][1];
                maxCiu = ciudades[i];
            }
        }



        //mostrar resultados
        System.out.println("La temperatura minima es: "+ minTemp + " en la cuidad " + minCiu);
        System.out.println("La temperatura maxima es: "+ maxTemp + " en la cuidad " + maxCiu);


    }

}

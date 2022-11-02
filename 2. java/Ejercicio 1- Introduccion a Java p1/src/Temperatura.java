import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {

        System.out.println("Ingrese las 10 ciudades con sus respectivas temeperaturas (mínima y máxima)");

        Scanner inputA = new Scanner(System.in);
        Scanner inputB = new Scanner(System.in);

        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];

        for (int i=0; i<10; i++){
            System.out.println("Ingrese el nombre de la ciudad "+ (i+1));
            ciudades[i]= inputA.nextLine();

            System.out.println("Ingrese la mínima de " + ciudades[i]);
            temperaturas[i][0]= inputB.nextInt();

            System.out.println("Ingrese la máxima de " + ciudades[i]);
            temperaturas[0][i]= inputB.nextInt();
        }

        int tempMin, tempMax;
        String ciuMin, ciuMax;

        tempMin = tempMax = temperaturas[0][0];
        ciuMin = ciuMax = ciudades[0];

        for (int i=0; i<10; i++){
            if (tempMin > temperaturas[i][0]){
                tempMin = temperaturas[i][0];
                ciuMin = ciudades[i];
            } else{
                if (tempMax < temperaturas[i][1]){
                    tempMax = temperaturas[i][1];
                    ciuMax = ciudades[i];
                }
            }

        }

        System.out.println("La menor temperatura es la de la de la ciudad de "+ ciuMin + " y es de "+ tempMin);
        System.out.println("La mayor temperatura es la de la ciudad de "+ ciuMax + " y es de "+ tempMax);
    }
}
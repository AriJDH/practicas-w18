package Temperatura.Clases;

public class Main {
    private static String ciudades[] = new String[10];
    private static int temperatura[][] = new int[10][2];

    public static void main(String[] args) {
        LlenarArregos();
        Run(ciudades, temperatura, 1);
        Run(ciudades, temperatura, 2);


    }

    private static void Run(String[] ciudades, int[][] temperatura, int operacion) {
        int aux = 0;
        int indice = 0;

        if(operacion == 1) //Filas
        {
            for (int i = 0; i < ciudades.length; i++) {
                if (temperatura[i][0] < aux) {
                    aux = temperatura[i][0];
                    indice = i;
                }
            }

            System.out.println("La temperatura más baja es " + aux + " en la ciudad " + ciudades[indice]);
        }else{
            for (int i = 0; i < ciudades.length; i++) {
                if (temperatura[i][1] > aux) {
                    aux = temperatura[i][1];
                    indice = i;
                }
            }

            System.out.println("La temperatura más alta es " + aux + " en la ciudad " + ciudades[indice]);
        }
    }

    private static void LlenarArregos() {
        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="Sao Paulo";

        temperatura[0][0] = -2;
        temperatura[0][1] = 33;
        temperatura[1][0] = -3;
        temperatura[1][1] = 32;
        temperatura[2][0] = -8;
        temperatura[2][1] = 27;
        temperatura[3][0] = 4;
        temperatura[3][1] = 37;
        temperatura[4][0] = 6;
        temperatura[4][1] = 42;
        temperatura[5][0] = 5;
        temperatura[5][1] = 43;
        temperatura[6][0] = 0;
        temperatura[6][1] = 39;
        temperatura[7][0] = -7;
        temperatura[7][1] = 26;
        temperatura[8][0] = -1;
        temperatura[8][1] = 31;
        temperatura[9][0] = -10;
        temperatura[9][1] = 35;
    }

}

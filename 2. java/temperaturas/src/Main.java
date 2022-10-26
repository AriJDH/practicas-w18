import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String ciudades [] = new String [10];
        int temperaturas [][] = new int [10][2];

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa las 10 ciudades: ");
        for(int i =0 ; i< ciudades.length; i++){
            ciudades[i] = entrada.nextLine();
        }
        System.out.println("Ingrese los 10 pares de temperaturas: ");
        for(int i = 0; i<10 ; i++){
            for(int j = 0; j< 2; j++){
                temperaturas[i][j]= entrada.nextInt();
            }
        }
        int menor = 0;
        int mayor = 0;
        int posMayor = 0;
        int posMenor = 0;
        for(int i = 0; i<10 ; i++){
            if( temperaturas[i][0] < menor){
                menor = temperaturas[i][0];
                posMenor = i;
            }
        }

        for(int i = 0; i<10 ; i++){
            if( temperaturas[i][1] > mayor){
                mayor = temperaturas[i][1];
                posMayor = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[posMenor] + ", con " + temperaturas[posMenor][0]+ " º C.");

        System.out.println("La mayor temperatura la tuvo " + ciudades[posMayor] + ", con " + temperaturas[posMayor][1]+ " º C.");
    }


}
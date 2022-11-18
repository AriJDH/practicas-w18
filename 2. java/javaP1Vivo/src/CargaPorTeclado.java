import java.util.Scanner;

public class CargaPorTeclado {
    public static void main(String[] args) {
        //Declaración e inicialización del vector ciudades
        String ciudades[] = new String[10];
        //Carga por teclado del vector ciudades
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Por favor ingrese el nombre de la ciudad número "+(i+1));
            ciudades[i]=teclado.nextLine();
        }

        //Declaración e inicialización de la matriz de 10 filas y 2 columnas
        int temperaturas[][]= new int[10][2];

        //Carga por teclado de las temperaturas mínimas
        for (int f = 0; f < temperaturas.length ; f++) {
            System.out.println("Ingrese la temperatura mínima para la ciudad de "+ciudades[f]);
            temperaturas[f][0] = teclado.nextInt();
        }

        //Carga por teclado de las temperaturas máximas
        for (int f = 0; f < temperaturas.length ; f++) {
            System.out.println("Ingrese la temperatura máxima para la ciudad de "+ciudades[f]);
            temperaturas[f][1] = teclado.nextInt();
        }
        teclado.close();

        //Declaración de variables auxiliares
        int temperaturaMinima=0;
        int temperaturaMaxima=0;
        String ciudadMinima ="";
        String ciudadMaxima ="";

        for (int f = 0; f < temperaturas.length ; f++) {
            for (int c = 0; c < temperaturas[f].length ; c++) {
                if (temperaturas[f][c]< temperaturaMinima){
                    temperaturaMinima = temperaturas[f][c];
                    ciudadMinima = ciudades[f];

                } else if (temperaturas[f][c]> temperaturaMaxima){
                    temperaturaMaxima = temperaturas[f][c];
                    ciudadMaxima = ciudades[f];

                }
            }

        }
        System.out.println("La menor temperatura la tuvo la ciudad de "+ciudadMinima+" con "+temperaturaMinima+"ºC.");
        System.out.println("La mayor temperatura la tuvo la ciudad de "+ciudadMaxima+" con "+temperaturaMaxima+"ºC.");
    }
}

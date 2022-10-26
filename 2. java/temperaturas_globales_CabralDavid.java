import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maximo, minimo, indiceMinimo, indiceMaximo;
        Scanner teclado = new Scanner(System.in);
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = new int[10][2];

        //Recorremos la matriz de temperaturas y le cargamos las temperaturas minimas y maximas
        for (int f=0; f < temperaturas.length; f++){
            for (int c=0; c < temperaturas[f].length; c++){
                System.out.println("Ingrese la temperatura minima y maxima respectivamente para la ciudad: "+ciudades[f]);
                temperaturas[f][c] = teclado.nextInt();
            }
        }

        //Seteamos las temperaturas minimas y maximas de la primera fila de la matriz y guardamos el primer indice
        minimo = temperaturas[0][0];
        maximo = temperaturas[0][1];
        indiceMinimo = 0;
        indiceMaximo = 0;

        //recorremos la matriz de temperaturas y vamos comparando las temperaturas para setear la minima y maxima
        //y guardamos el indice de cada una.
        for (int f=0; f < temperaturas.length; f++){
            for (int c=0; c < temperaturas[f].length; c++){
                if(temperaturas[f][c] < minimo){
                    minimo = temperaturas[f][c];
                    indiceMinimo = f;
                }
                if(temperaturas[f][c] > maximo){
                    maximo = temperaturas[f][c];
                    indiceMaximo = f;
                }

            }
        }

        System.out.println("La menor temperatura la tuvo la ciudad de: "+ciudades[indiceMinimo]+" con "+minimo+"C.");
        System.out.println("La maxima temperatura la tuvo la ciudad de: "+ciudades[indiceMaximo]+" con "+maximo+"C.");
    }

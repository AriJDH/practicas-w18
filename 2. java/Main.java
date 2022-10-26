import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        String vectorCiudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao paulo","Lima","Santiago de Chile","Lisboa","Tokio"}; //10
        double matrizTemperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};//10-2
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;

        tempMinima = matrizTemperaturas[0][0];
        ciudadMinima = vectorCiudades[0];
        tempMaxima = matrizTemperaturas[0][0];
        ciudadMaxima = vectorCiudades[0];
        //Recorrido para encontrar la temperatura mínima y máxima
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 2; j++) {

                //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[i][j]<tempMinima){
                    tempMinima=matrizTemperaturas[i][j];
                    ciudadMinima=vectorCiudades[i];
                }
                //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[i][j]>tempMaxima){
                    tempMaxima=matrizTemperaturas[i][j];
                    ciudadMaxima=vectorCiudades[i];
                }

            }

        }
        System.out.println("La ciudad " + ciudadMinima + " tiene la temperatura minima con un valor de: " + tempMinima);
        System.out.println("La ciudad " + ciudadMaxima + " tiene la temperatura minima con un valor de: " + tempMaxima);
    }
}

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Londres");
        ciudades.add("Madrid");
        ciudades.add("Nueva York");
        ciudades.add("Buenos Aires");
        ciudades.add("Asuncion");
        ciudades.add("Sao Paulo");
        ciudades.add("Lima");
        ciudades.add("Santiago");
        ciudades.add("Lisboa");
        ciudades.add("Tokio");

        int temperaturas[][] = new int[6][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;

        int minima = temperaturas[0][0];
        int maxima = temperaturas[0][1];
        int indiceMin = 0;
        int indiceMax = 0;

        for(int i=0; i<temperaturas.length ; i++){
            for(int j=0; j<2 ; j++){
                if(temperaturas[i][j] < minima){
                    minima = temperaturas[i][j];
                    indiceMin = i;
                }
                if(temperaturas[i][j] > maxima){
                    maxima = temperaturas[i][j];
                    indiceMax = i;
                }
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades.get(indiceMin) + " con " + minima + " ºC");
        System.out.println("La mayor temperatura la tuvo " + ciudades.get(indiceMax) + " con " + maxima + " ºC");
    }

}
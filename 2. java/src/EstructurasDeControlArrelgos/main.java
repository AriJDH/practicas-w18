package EstructurasDeControlArrelgos;

public class main {
    public static void main (String[] args){
        int mayor, menor;
        String ciudades[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int Temperaturas[][] = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };
        for (int i = 0; i < ciudades.length; i++){
            System.out.printf("La Ciudad %s, su tempertura maxima es: %d , y su minima es de: %d\n",ciudades[i],Temperaturas[i][0],Temperaturas[i][1]);
        }
    }
}

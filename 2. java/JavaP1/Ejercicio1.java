public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunciòn", "Sao Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        for (String ciudad : ciudades) {
            System.out.println(ciudad);
        }

        float[][] temperaturas;
        temperaturas = new float[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35},
        };
        float min = temperaturas[0][0];
        float max = temperaturas[0][1];

        int idx_min = 0, idx_max = 0;


        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                System.out.println("Indice" + i + "->" + temperaturas[i][j]);
            }
        }

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < min) {
                min = temperaturas[i][0];
                idx_min = i;
            }
            if (temperaturas[i][1] > max) {
                max = temperaturas[i][1];
                idx_max = i;
            }
        }

        System.out.println("La temperatura minima es " + min + " en la ciudad de " + ciudades[idx_min]);
        System.out.println("La temperatura maxima es " + max + " en la ciudad de " + ciudades[idx_max]);

    }

}
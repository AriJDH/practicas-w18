package java_p1;

public class TempGlobales {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas =
                {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minTemp = Integer.MAX_VALUE;
        int minPos = 0;
        int maxTemp = Integer.MIN_VALUE;
        int maxPos = 0;

        for (int i = 0; i < ciudades.length; i++) {
            int min = temperaturas[i][0];
            int max = temperaturas[i][1];

            if (min < minTemp) {
                minTemp = min;
                minPos = i;
            }
            if (max > maxTemp) {
                maxTemp = max;
                maxPos = i;
            }
        }

        System.out.println("La temperatura minima fue " + minTemp + " en la ciudad " + ciudades[minPos]);
        System.out.println("La temperatura maxima fue " + maxTemp + " en la ciudad " + ciudades[maxPos]);
    }
}

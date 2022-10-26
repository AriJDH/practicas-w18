public class Main {

    public static void main(String[] args) {

        String[] cities = new String[] {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] tempsMinMax = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int minTemp = tempsMinMax[0][0];
        int maxTemp = tempsMinMax[0][1];
        String minCity = cities[0];
        String maxCity = cities[0];
        for (int i = 0; i < tempsMinMax.length; i++) {
            // min
            if (tempsMinMax[i][0] < minTemp) {
                minTemp = tempsMinMax[i][0];
                minCity = cities[i];
            }
            if (tempsMinMax[i][1] > maxTemp) {
                maxTemp = tempsMinMax[i][1];
                maxCity = cities[i];
            }
        }

        System.out.println("La menor temperatura la tuvo " + minCity + " con " + minTemp + " ºC");
        System.out.println("La mayor temperatura la tuvo " + maxCity + " con " + maxTemp + " ºC");
    }
}
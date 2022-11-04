public class Temperatures {

    public static void main(String[] args) {

        String[] cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        double[][] temperatures = new double[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        double minTemperature = temperatures[0][0], maxTemperature = temperatures[0][0];
        String minTemCity = cities[0], maxTemCity = cities[0];
        //Recorrido para obtener temperatura min y max
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 1; j++) {
                //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                if (temperatures[i][j] < minTemperature) {
                    minTemperature = temperatures[i][j];
                    minTemCity = cities[i];
                }
                //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                if (temperatures[i][j] > maxTemperature) {
                    maxTemperature = temperatures[i][j];
                    maxTemCity = cities[i];
                }
            }
        }
        System.out.println("La ciudad de " + minTemCity + " es la ciudad con la temperatura mínima de: " + minTemperature);
        System.out.println("La ciudad de " + maxTemCity + " es la ciudad con la temperatura máxima de: " + maxTemperature);
    }
}

package introductionJava.exercises;

public class Temperaturas_Globales {

  public static void main(String[] args) {
    String[] cities = {
      "Londres",
      "Madrid",
      "Nueva York",
      "Buenos Aires",
      "Asunción",
      "São Paulo",
      "Lima",
      "Santiago de Chile",
      "Lisboa",
      "Tokio",
    };

    int[][] temperatures = {
      { -2, 33 },
      { -3, 32 },
      { -8, 27 },
      { 4, 37 },
      { 6, 42 },
      { 5, 43 },
      { 0, 39 },
      { -7, 26 },
      { -1, 31 },
      { -10, 35 },
    };

    int lessTemperatureIndex = 0;
    int higherTemperatureIndex = 0;

    for (int i = 0; i < temperatures.length; i++) {
      System.out.println(i + " " + cities[i] + " " + temperatures[i][0]);

      if (temperatures[lessTemperatureIndex][0] < temperatures[i][0]) {
        lessTemperatureIndex = i;
      }

      if (temperatures[higherTemperatureIndex][0] > temperatures[i][0]) {
        higherTemperatureIndex = i;
      }
    }

    System.out.println(
      "La ciudad con mayor temperatura es: " +
      cities[higherTemperatureIndex] +
      ", con " +
      temperatures[higherTemperatureIndex][0] +
      " º C. Y la ciudad con menor temperatura es: " +
      cities[lessTemperatureIndex] +
      ", con " +
      temperatures[lessTemperatureIndex][0] +
      " º C. "
    );
  }
}

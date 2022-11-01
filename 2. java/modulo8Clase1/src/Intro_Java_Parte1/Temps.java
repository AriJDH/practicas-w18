package Intro_Java_Parte1;

public class Temps {
    public static void main(String[] args) {

        String paises[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};
        int ciudadMin = 0;
        int ciudadMax = 0;
        int tempMinMax[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int tempMin = tempMinMax[0][0];
        int tempMax = tempMinMax[0][1];

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if ((j == 0) && (tempMinMax[i][j] < tempMin)) {
                    tempMin = tempMinMax[i][j];
                    ciudadMin = i;
                } else {
                    if ((j == 1) && (tempMinMax[i][j] > tempMax)) {
                        tempMax = tempMinMax[i][j];
                        ciudadMax = i;
                    }
                }
            }
        }
        System.out.println("La menor temperatura la tuvo la ciudad: " + paises[ciudadMin] + " con una temperatura de: " + tempMin + "\n");
        System.out.println("La mayor temperatura la tuvo la ciudad: " + paises[ciudadMax] + " con una temperatura de: " + tempMax);

    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Temperatura");

        int max = 0;
        int min = 0;

        String ciudades[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "San Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},
                {5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int ciudadMenorTemperatura = 0;
        int ciudadMayorTemperatura = 0;

        for(int x = 0; x < temperaturas.length; x++){
            for(int y = 0; y < temperaturas[x].length; y++){

                if (temperaturas[x][y] < min){
                    min = temperaturas[x][y];
                    ciudadMenorTemperatura = x;

                } if (temperaturas[x][y] > max) {
                    max = temperaturas[x][y];
                    ciudadMayorTemperatura = x;
                }
            }

        }

        System.out.println("La ciudad con menor temperatura es: " + ciudades[ciudadMenorTemperatura]);
        System.out.println("La temperatura es: " + min);
        System.out.println("La ciudad con mayor temperatura es: " + ciudades[ciudadMayorTemperatura]);
        System.out.println("La temperatura es: " + max);

    }

}

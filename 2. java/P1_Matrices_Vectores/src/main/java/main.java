public class main {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        int temperaturas[][] = {{-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturaMaxima= temperaturas[0][1];
        int temperaturaMinima= temperaturas[0][0];
        String ciudadTemperaturaMaxima = null;
        String ciudadTemperaturaMinima = null;

        for (int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i][0]<temperaturaMinima){
                temperaturaMinima= temperaturas[i][0];
                ciudadTemperaturaMinima = ciudades[i];
            }
            if(temperaturas[i][1]>temperaturaMaxima){
                temperaturaMaxima= temperaturas[i][1];
                ciudadTemperaturaMaxima= ciudades[i];
            }

        }

        System.out.println("La ciudad con la temperatura minima es : " + ciudadTemperaturaMinima + " con " + temperaturaMinima + " ° C");
        System.out.println("La ciudad con la temperatura maxima es : " + ciudadTemperaturaMaxima + " con " + temperaturaMaxima + " ° C");
    }
}
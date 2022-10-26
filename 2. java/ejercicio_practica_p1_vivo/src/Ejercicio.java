public class Ejercicio {

    /**
     * Metodo ejecutora de la clase
     * @param args
     */
    public static void main(String[] args) {

        String[] ciudades = construirCiudades();
        int[][] temperaturas = construirTemperaturas();

        obtenerInformacion(ciudades, temperaturas);
    }

    /**
     * Metodo encargado de construir el arreglo de ciudades
     * @return arreglo con las ciudades seteadas
     */
    private static String[] construirCiudades() {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        return ciudades;
    }

    /**
     * Metodo encargado de construir la matriz de las temperaturas
     * @return matriz con la informacion de las temperaturas
     */
    private static int[][] construirTemperaturas() {

        int[][] temperaturas = {
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

        return temperaturas;
    }

    /**
     * Metodo encargado de obtener la informacion que se necesita para el ejercicio a partir del arreglo
     * de ciudades y la matriz de temperaturas
     */
    private static void obtenerInformacion(String[] ciudades, int[][] temperaturas) {

        int indiceCiudadMasFria = 0;
        int indiceCiudadMasCaliente = 0;
        int temperaturaMasFria = 0;
        int temperaturaMasCaliente = 0;
        
        for (int i = 0; i < 10; i++) {

            int temperaturaCiudadFria = temperaturas[i][0];
            int temperaturaCiudadCaliente = temperaturas[i][1];
            
            if (temperaturaCiudadFria < temperaturaMasFria) {
                temperaturaMasFria = temperaturaCiudadFria;
                indiceCiudadMasFria = i;
            }

            if (temperaturaCiudadCaliente > temperaturaMasCaliente) {
                temperaturaMasCaliente = temperaturaCiudadCaliente;
                indiceCiudadMasCaliente = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indiceCiudadMasFria] + " con " + temperaturaMasFria + "*C");
        System.out.println("La mayor temperatura la tuvo " + ciudades[indiceCiudadMasCaliente] + " con " + temperaturaMasCaliente + "*C");

    }
}

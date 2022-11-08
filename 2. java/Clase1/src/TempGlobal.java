public class TempGlobal {
    private String[] ciudades;
    private int[][] temperaturas;
    public void cargarDatos(){
        ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[1][0] = -3;
        temperaturas[2][0] = -8;
        temperaturas[3][0] = 4;
        temperaturas[4][0] = 6;
        temperaturas[5][0] = 5;
        temperaturas[6][0] = 0;
        temperaturas[7][0] = -7;
        temperaturas[8][0] = -1;
        temperaturas[9][0] = -10;
        temperaturas[0][1] = 33;
        temperaturas[1][1] = 32;
        temperaturas[2][1] = 27;
        temperaturas[3][1] = 37;
        temperaturas[4][1] = 42;
        temperaturas[5][1] = 43;
        temperaturas[6][1] = 39;
        temperaturas[7][1] = 26;
        temperaturas[8][1] = 31;
        temperaturas[9][1] = 35;
    }

    public void minMax(){
        int min,max;
        min = temperaturas[0][0];
        max = temperaturas[0][1];
        String ciudadMin, ciudadMax;
        ciudadMin = ciudades[0];
        ciudadMax = ciudades[0];
        for (int i=1; i<10; i++){
            if (min >= temperaturas[i][0]) {
                min = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
            if (max <= temperaturas[i][1]) {
                max = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }
        System.out.println("Minima en "+ciudadMin + " temperatura " + min);
        System.out.println("Maxima en "+ciudadMax + " temperatura " + max);

    }

    public static void main(String[] args) {
        TempGlobal tg = new TempGlobal();
        tg.cargarDatos();
        tg.minMax();
    }
}

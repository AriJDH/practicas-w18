public class Main {
    public static void main(String[] args) {

        String ciudades[] = { "Londres" ,
                "Madrid" ,
                "Nueva York" ,
                "Buenos Aires" ,
                "Asuncion" ,
                "Sao Paulo" ,
                "Lima" ,
                "Santiago de Chile" ,
                "Lisboa" ,
                "Tokyo"
                };
        Integer temperaturas[][] = new Integer[10][2];

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 30;

        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;

        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;

        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;

        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;

        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;

        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;

        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;

        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;

        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int nombreCiudadMayor = 0;
        int nombreCiudadMenor = 0;

        int tempMayor = 0;
        int tempMenor = Integer.MAX_VALUE;

        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < temperaturas[i].length; j++){
                if(temperaturas[i][j] > tempMayor){
                    tempMayor = temperaturas[i][j];
                    nombreCiudadMayor = i;
                }
                if(temperaturas[i][j] < tempMenor){
                    tempMenor = temperaturas[i][j];
                    nombreCiudadMenor = i;
                }
            }
        }

        System.out.println("La ciudad con mayor temperatura es " + ciudades[nombreCiudadMayor]+ " con " + tempMayor + " grados Celsius");
        System.out.println("La ciudad con menor temperatura es " + ciudades[nombreCiudadMenor]+ " con " + tempMenor + " grados Celsius");




    }



}
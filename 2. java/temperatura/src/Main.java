public class Main {

        public static void main(String[] args) {
            String ciudades[] = new String [10];
            int temperaturas[][] = new int [10][2];

            ciudades[0] = "Londres";
            ciudades[1] = "Madrid";
            ciudades[2] = "Nueva York";
            ciudades[3] = "Buenos Aires";
            ciudades[4] = "Asunción";
            ciudades[5] = "Sao Pablo";
            ciudades[6] = "Lima";
            ciudades[7] = "Santiago";
            ciudades[8] = "Lisboa";
            ciudades[9] = "Tokio";

            temperaturas[0][0] = -2;
            temperaturas[0][1] = 33;
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

            int temperaturaMinima = 0;
            int temperaturaMaxima = 0;
            String ciudadMinima = "";
            String ciudadMaxima = "";

            for(int f = 0; f < temperaturas.length; f ++){
                for(int c = 0; c<2; c++){
                    if(temperaturas[f][c]<temperaturaMinima){
                        temperaturaMinima = temperaturas[f][c];
                        ciudadMinima = ciudades[f];

                    }else if(temperaturas[f][c]>temperaturaMaxima){
                        temperaturaMaxima = temperaturas[f][c];
                        ciudadMaxima = ciudades[f];
                    }
                }
            }

            System.out.println("La menor temperatura fue de " + ciudadMinima + " con " + temperaturaMinima + " y la mayor temperatura fue de " + ciudadMaxima + " con " + temperaturaMaxima);

        }

}

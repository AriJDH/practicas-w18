public class Clima {
    public void asignaValores(){
        int temperatura[][] = new int [10][2];
        String [] ciudad = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        temperatura [0][0] = -2;
        temperatura [0][1] = 33;
        temperatura [1][0] = -3;
        temperatura [1][1] = 32;
        temperatura [2][0] = -8;
        temperatura [2][1] = 27;
        temperatura [3][0] = 4;
        temperatura [3][1] = 37;
        temperatura [4][0] = 6;
        temperatura [4][1] = 42;
        temperatura [5][0] = 5;
        temperatura [5][1] = 43;
        temperatura [6][0] = 0;
        temperatura [6][1] = 39;
        temperatura [7][0] = -7;
        temperatura [7][1] = 26;
        temperatura [8][0] = -1;
        temperatura [8][1] = 31;
        temperatura [9][0] = -10;
        temperatura [9][1] = 35;

        imprimeTemperatura(temperatura);
        temperaturaMinima(temperatura, ciudad);
        temperaturaMaxima(temperatura, ciudad);
    }

    public void imprimeTemperatura(int [] [] temperatura1){
        for(int i = 0; i<10; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(temperatura1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void temperaturaMinima(int [] [] temperatura1,  String [] ciudad){
        int valorTemporal = temperatura1[0][1];
        String  valorTemporalCiudad = null;
        for(int i = 0; i<10; i++) {
            for (int j = 0; j < 2; j++) {
                if(temperatura1[i][j] == valorTemporal){
                    valorTemporal = temperatura1[i][j];
                    valorTemporalCiudad = ciudad[i];
                }else if(temperatura1[i][j] < valorTemporal){
                    valorTemporal = temperatura1[i][j];
                    valorTemporalCiudad = ciudad[i];
                }
            }
        }
        System.out.println("La ciudad es " + valorTemporalCiudad);
        System.out.println("Su temperatura minima es "+ valorTemporal);
    }

    public void temperaturaMaxima(int [] [] temperatura1,  String [] ciudad){
        int valorTemporal = temperatura1[0][1];
        String valorTemporalCiudad = null;
        for(int i = 0; i<10; i++) {
            for (int j = 0; j < 2; j++) {
                if(temperatura1[i][j] == valorTemporal){
                    valorTemporal = temperatura1[i][j];
                    valorTemporalCiudad = ciudad[i];
                }else if(temperatura1[i][j] > valorTemporal){
                    valorTemporal = temperatura1[i][j];
                    valorTemporalCiudad = ciudad[i];
                }
            }
        }
        System.out.println("La ciudad " + valorTemporalCiudad);
        System.out.println("Su temperatura maxima es "+ valorTemporal);
    }

    public static void main(String [] args){
        Clima clima = new Clima();
        clima.asignaValores();
    }
}


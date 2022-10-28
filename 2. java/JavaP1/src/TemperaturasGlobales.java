public class TemperaturasGlobales {
    String ciudades[];
    int[][] temperaturas;

    int menorTemperatura;
    String ciudadMenorTemperatura;

    int mayorTemperatura;
    String ciudadMayorTemperatura;

    public void inicializar(){
        ciudades = new String[10];
        temperaturas = new int[10][2];

        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="Sao Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        temperaturas[0][0]=-2; temperaturas[0][1]=33;
        temperaturas[1][0]=-3; temperaturas[1][1]=32;
        temperaturas[2][0]=-8; temperaturas[2][1]=27;
        temperaturas[3][0]=4; temperaturas[3][1]=37;
        temperaturas[4][0]=6; temperaturas[4][1]=42;
        temperaturas[5][0]=5; temperaturas[5][1]=43;
        temperaturas[6][0]=0; temperaturas[6][1]=39;
        temperaturas[7][0]=-7; temperaturas[7][1]=26;
        temperaturas[8][0]=-1; temperaturas[8][1]=31;
        temperaturas[9][0]=-10; temperaturas[9][1]=35;
    }

    public String getCiudadMenorTemperatura(){
        return ciudadMenorTemperatura;
    }

    public String getCiudadMayorTemperatura(){
        return ciudadMayorTemperatura;
    }

    public int buscarMenorTemperatura(){
        menorTemperatura=temperaturas[0][0];
        for(int i=0; i<temperaturas.length; i++){ //longitud de filas=10
            for (int j=0; j<2; j++) { //longitud de columnas=2
                if (temperaturas[i][j]<menorTemperatura){
                    menorTemperatura=temperaturas[i][j];
                    ciudadMenorTemperatura=ciudades[i];
                }
            }
        }
        return menorTemperatura;
    }

    public int buscarMayorTemperatura(){
        mayorTemperatura=temperaturas[0][0];
        for(int i=0; i<temperaturas.length; i++){ //longitud de filas=10
            for (int j=0; j<2; j++) { //longitud de columnas=2
                if (temperaturas[i][j]>mayorTemperatura){
                    mayorTemperatura=temperaturas[i][j];
                    ciudadMayorTemperatura=ciudades[i];
                }
            }
        }
        return mayorTemperatura;
    }
}

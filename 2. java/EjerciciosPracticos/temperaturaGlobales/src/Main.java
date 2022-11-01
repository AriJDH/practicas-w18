public class Main {
    public static void main(String[] args) {

        String ciudades[]=new String[10];
        double temperaturas[][]=new double[10][2];
        double tempMin=0;
        double tempMax=0;
        int pais1=0;
        int pais2=0;

        //Inicializo el vector Ciudades
        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asuncion";
        ciudades[5]="Säo Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        //Inicializo la matriz temperaturas
        temperaturas[0][0]=-2;
        temperaturas[0][1]=33;
        temperaturas[1][0]=-3;
        temperaturas[1][1]=32;
        temperaturas[2][0]=-8;
        temperaturas[2][1]=27;
        temperaturas[3][0]=4;
        temperaturas[3][1]=37;
        temperaturas[4][0]=6;
        temperaturas[4][1]=42;
        temperaturas[5][0]=5;
        temperaturas[5][1]=43;
        temperaturas[6][0]=0;
        temperaturas[6][1]=39;
        temperaturas[7][0]=-7;
        temperaturas[7][1]=26;
        temperaturas[8][0]=-1;
        temperaturas[8][1]=31;
        temperaturas[9][0]=-10;
        temperaturas[9][1]=35;


        //Ciclo para análisis de resultados
        for (int i=0; i<10; i++){
            for (int j=0; j<2; j++){
                if(temperaturas[i][0]<tempMin){
                    tempMin=temperaturas[i][0];
                    pais1= i;
                }
                if(temperaturas[i][1]>tempMax){
                    tempMax=temperaturas[i][1];
                    pais2=i;
                }
            }
        }

        //Resultado
        System.out.println("La menor temperatura la tuvo " + ciudades[pais1] +" con "+tempMin + "°C");
        System.out.println("La mayor temperatura la tuvo " + ciudades[pais2] +" con "+tempMax + "°C");
    }
}
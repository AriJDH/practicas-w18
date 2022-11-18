public class CargaManual {

    public static void main(String[] args) {
        //Declaración e inicialización del vector ciudades
        String ciudades[] = new String[10];
        //Carga manual del vector ciudades
        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="São Pablo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        //Declaración e inicialización de la matriz de 10 filas y 2 columnas
        int temperaturas[][]= new int[10][2];
        //Carga manual de la matriz temperaturas
        temperaturas[0][0]=-2;
        temperaturas[1][0]=-3;
        temperaturas[2][0]=-8;
        temperaturas[3][0]=4;
        temperaturas[4][0]=6;
        temperaturas[5][0]=5;
        temperaturas[6][0]=0;
        temperaturas[7][0]=-7;
        temperaturas[8][0]=-1;
        temperaturas[9][0]=-10;
        temperaturas[0][1]=33;
        temperaturas[1][1]=32;
        temperaturas[2][1]=27;
        temperaturas[3][1]=37;
        temperaturas[4][1]=42;
        temperaturas[5][1]=43;
        temperaturas[6][1]=39;
        temperaturas[7][1]=26;
        temperaturas[8][1]=31;
        temperaturas[9][1]=35;

        String ciudad = "";
        int temperaturaMinima = 0;

        //Recorrido de la primera columna (temperaturas mínimas)
        for (int f = 0; f <temperaturas.length; f++) {
            if(temperaturas[f][0]<temperaturaMinima){
                temperaturaMinima = temperaturas[f][0];
                ciudad = ciudades[f];
            }
        }
        System.out.println("La menor temperatura la tuvo la ciudad de "+ciudad+" con "+temperaturaMinima+"ºC.");

        int temperaturaMaxima = 0;
        //Recorrido de la segunda columna (temperaturas máximas)
        for (int f = 0; f < temperaturas.length; f++) {
            if(temperaturas[f][1]>temperaturaMaxima){
                temperaturaMaxima = temperaturas[f][1];
                ciudad = ciudades[f];
            }
        }
        System.out.println("La mayor temperatura la tuvo la ciudad de "+ciudad+" con "+temperaturaMaxima+"ºC.");
    }
}

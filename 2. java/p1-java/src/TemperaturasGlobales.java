public class TemperaturasGlobales {

    public static void main(String[] args) {
        String ciudades[]={"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo", "Lima",
                "Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][]={{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int maxT=temperaturas[0][1];
        String maxCity=ciudades[0];
        int minT=temperaturas[0][0];
        String minCity=ciudades[0];


        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i][1]>maxT){
                maxT=temperaturas[i][1];
                maxCity=ciudades[i];
            }
            if (temperaturas[i][0]<minT){
                minT=temperaturas[i][0];
                minCity=ciudades[i];
            }
        }
        System.out.println("La temperatura máxima es de: "+maxT+" ºC. Pertenece a: "+maxCity);
        System.out.println("La temperatura mínima es de: "+minT+" ºC. Pertenece a: "+minCity);

    }
}

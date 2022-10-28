package TemperaturaGlobal;

public class TemperaturaGlobal {

    private String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paolo","Lima","Santiago chile","Lisboa","Tokio"};
    private int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

    public void hottestCity(){
        int maxTempeture = temperaturas[0][1];
        String city = ciudades[0];
        for(int i = 1; i < temperaturas.length; i++){
            if(maxTempeture < temperaturas[i][1]){
                city = ciudades[i];
                maxTempeture = temperaturas[i][1];
            }
        }

        System.out.println(city + " es la ciudad mas calurosa con " + maxTempeture + "°C");
    }

    public void coldestCity(){
        int minTempeture = temperaturas[0][0];
        String city = ciudades[0];
        for(int i = 1; i < temperaturas.length; i++){
            if(minTempeture > temperaturas[i][0]){
                city = ciudades[i];
                minTempeture = temperaturas[i][0];
            }
        }

        System.out.println(city + " es la ciudad mas fria con " + minTempeture + "°C");
    }

}

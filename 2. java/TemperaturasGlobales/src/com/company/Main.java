package com.company;

public class Main {

    public static void main(String[] args) {
        int MIN_TEMP_INDEX=0;
        int MAX_TEMP_INDEX=1;
	String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "San Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
	double[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
	double minTemp = temperaturas[0][MIN_TEMP_INDEX];
	String minTempCiudad = ciudades[0];
	double maxTemp=temperaturas[0][MAX_TEMP_INDEX];
	String maxTempCiudad = minTempCiudad;

	for(int i=0; i<10;i++){
	    String currentCity=ciudades[i];
	    double currentMinTemp = temperaturas[i][MIN_TEMP_INDEX];
	    double currentMaxTemp=temperaturas[i][MAX_TEMP_INDEX];
	    if(currentMinTemp<minTemp){
	        minTemp=currentMinTemp;
	        minTempCiudad=currentCity;
        }
	    if(currentMaxTemp>maxTemp){
	        maxTemp=currentMaxTemp;
	        maxTempCiudad=currentCity;
        }
    }
    System.out.println("La temperatura mínima la tiene la ciudad "+ minTempCiudad+" y es de "+minTemp);
	System.out.println("La temperatura máxima la tiene la ciudad "+ maxTempCiudad+" y es de "+maxTemp);
    }
}

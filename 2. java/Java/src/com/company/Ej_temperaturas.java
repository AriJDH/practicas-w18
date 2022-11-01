package com.company;

public class Ej_temperaturas {

    public static void main(String[] args) {
	    String Ciudades[] = new String[]{"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo",
        "Lima","Santiago de Chile","Lisboa","Tokio"};
	    int Temperaturas[][] = new int[][] {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,39,26,31,35}}; // Columna 0 minimos, Columna 1 maximos
		int index_min = 0,index_max = 0;
		int min_temp = 100;
		int max_temp = -100;

	    for (int i=0; i< Temperaturas[0].length; i++){
	    	//Comprobar el minimo
			if (Temperaturas[0][i] < min_temp){
				min_temp = Temperaturas[0][i];
				index_min = i;
			}
			//Comprobar el maximo
			if (Temperaturas[1][i] > max_temp){
				max_temp = Temperaturas[1][i];
				index_max = i;
			}
		}

	    System.out.println("La ciudad " + Ciudades[index_min] + " tiene la temperatura minima igual a " + min_temp);
		System.out.println("La ciudad " + Ciudades[index_max] + " tiene la temperatura máxima igual a " + max_temp);


    }
}

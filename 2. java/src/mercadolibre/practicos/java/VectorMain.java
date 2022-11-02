package mercadolibre.practicos.java;

public class VectorMain {
	public static void main(String[] args) {

		// Vector unidimencional de ciudades
		String ciudades[] = new String[10];
		ciudades[0] = "Londres";
		ciudades[1] = "Madrid";
		ciudades[2] = "New York";
		ciudades[3] = "Buenos Aires";
		ciudades[4] = "Asuncion";
		ciudades[5] = "Sao Paulo";
		ciudades[6] = "Lima";
		ciudades[7] = "Santiago de Chile";
		ciudades[8] = "Lisboa";
		ciudades[9] = "Tokio";
		// Carga de temperaturas
		int temperaturas[][] = new int[10][2];
		temperaturas[0][0] = -2;
		temperaturas[1][0] = -3;
		temperaturas[2][0] = -8;
		temperaturas[3][0] = 4;
		temperaturas[4][0] = 6;
		temperaturas[5][0] = 5;
		temperaturas[6][0] = 0;
		temperaturas[7][0] = -7;
		temperaturas[8][0] = -1;
		temperaturas[9][0] = -10;
		temperaturas[0][1] = 33;
		temperaturas[1][1] = 32;
		temperaturas[2][1] = 27;
		temperaturas[3][1] = 37;
		temperaturas[4][1] = 42;
		temperaturas[5][1] = 43;
		temperaturas[6][1] = 39;
		temperaturas[7][1] = 26;
		temperaturas[8][1] = 31;
		temperaturas[9][1] = 35;

		boolean primeraVez = true;
		int mayorT = 0, minT = 0;
		String ciudadMayorT = "", ciudadMinT = "";
		// Recorro menor temperatura y guardo la misma
		for (int i = 0; i < 10; i++) {
			if (primeraVez) {
				minT = temperaturas[i][0];
				primeraVez = false;
			}

			if (temperaturas[i][0] <= minT) {
				minT = temperaturas[i][0];
				ciudadMinT = ciudades[i];
			}

		}
		primeraVez = true;
		// Recorro maxima temperatura y guardo la misma
		for (int i = 0; i < 10; i++) {
			if (primeraVez) {
				mayorT = temperaturas[i][1];
				primeraVez = false;
			}

			if (temperaturas[i][1] >= mayorT) {
				mayorT = temperaturas[i][1];
				ciudadMayorT = ciudades[i];
			}

		}
		// Pinto ciudades con menor y mayor temperatura
		System.out.println("La ciudad con menos temperatura es: " + ciudadMinT + " con " + minT + " grados.");
		System.out.println("La ciudad con mayor temperatura es: " + ciudadMayorT + " con " + mayorT + " grados.");

	}
}

package practico2;

public class Main {
	
	public static void main(String[] args) {
		PracticaExcepciones pra = new PracticaExcepciones();
		try {
			pra.calcularCociente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

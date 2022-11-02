package practico2;

public class PracticaExcepciones {
	
	private int a = 0;
	
	private int b = 300;
	
	public int calcularCociente() throws Exception {
		
		try {
			
			return b/a;
			
		}catch(IllegalArgumentException ex) {
			throw new Exception("No se puede dividir por cero");
		}finally {
			System.out.println("Programa finalizado");
		}
	}

}

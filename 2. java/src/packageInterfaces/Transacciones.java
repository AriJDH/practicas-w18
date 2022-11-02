package packageInterfaces;

public interface Transacciones {

	default void transaccionOK() {
		
		System.out.println("Transaccion Ok");
		
	}
	
	default void transaccionNoOK() {
		
		System.out.println("Transaccion no Ok");
		
	}
	
}

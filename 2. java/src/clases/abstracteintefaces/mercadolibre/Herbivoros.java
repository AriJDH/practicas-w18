package clases.abstracteintefaces.mercadolibre;

public interface Herbivoros {
	
	default void comoHierba() {
		System.out.println("Yo como plantas");
	}

}

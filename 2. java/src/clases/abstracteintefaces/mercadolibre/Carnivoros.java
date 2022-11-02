package clases.abstracteintefaces.mercadolibre;

public interface Carnivoros {

	default void comerCarne() {
		System.out.println("Soy un animal que comer Carne");
	}
}

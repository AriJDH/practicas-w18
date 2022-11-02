package clases.abstracteintefaces.mercadolibre;

public class Perro extends Animal implements Carnivoros{

	@Override
	public void hacerRuido() {
		System.out.println("El perro ahce GuauGuau");
	}

}

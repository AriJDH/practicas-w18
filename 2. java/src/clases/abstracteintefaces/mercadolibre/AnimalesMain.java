package clases.abstracteintefaces.mercadolibre;

public class AnimalesMain {
	
	public static void main(String[] args) {
		
		Perro perro = new Perro();
		perro.comerCarne();
		perro.hacerRuido();
		
		Gato gato = new Gato();
		gato.comerCarne();
		gato.hacerRuido();
		
		Vaca vaca = new Vaca();
		vaca.comoHierba();
		vaca.hacerRuido();
		
	}

}

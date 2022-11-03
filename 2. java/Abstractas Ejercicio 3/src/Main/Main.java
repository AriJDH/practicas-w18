package Main;

import Clases.Perro;
import Clases.Vaca;

public class Main {

    public static void main(String[] args) {
		Perro perrito = new Perro();
		System.out.println(perrito.hacerSonido());
		System.out.println(perrito.comerCarne());
		System.out.println(perrito.comerAnimal(perrito));

		Vaca vaquita = new Vaca();
		System.out.println(vaquita.hacerSonido());
		System.out.println(vaquita.comerHierba());
		System.out.println(vaquita.comerAnimal(vaquita));

    }
}

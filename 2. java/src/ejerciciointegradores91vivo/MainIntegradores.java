package ejerciciointegradores91vivo;

import java.util.ArrayList;
import java.util.List;

public class MainIntegradores {
	
	public static void main(String[] args) {
		
		RepositorioLocalizadorImpl repo = new RepositorioLocalizadorImpl();
		
		Paquete paquete1 = new Paquete(true, true, true, true);
		Paquete paquete2 = new Paquete(true, false, true, false);
		Paquete paquete3 = new Paquete(true, true, true, true);
		Paquete paquete4 = new Paquete(false, true, true, false);
		
		Cliente cliente1 = new Cliente("Meli", 50000000);
		Cliente cliente2 = new Cliente("Agus", 11111111);
		Cliente cliente3 = new Cliente("Lulu", 22222222);
		
		List<Paquete> lista1Paquete = List.of(paquete1,paquete2);
		List<Paquete> lista2Paquete = List.of(paquete3);
		List<Paquete> lista3Paquete = List.of(paquete4);
		
		Localizador localizador1 = new Localizador(cliente3, lista1Paquete);
		repo.almacenarLocalizador(localizador1);
		repo.imprimirLocalizadorGenerado(localizador1);
		localizador1.calcularTotal();
		
	}

}

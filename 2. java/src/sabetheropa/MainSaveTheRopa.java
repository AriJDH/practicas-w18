package sabetheropa;

import java.util.List;

public class MainSaveTheRopa {
	
	public static void main(String[] args) {
		
		Prenda prenda1 = new Prenda("Nike", "Buzo");
		Prenda prenda2 = new Prenda("Addidas", "Canguro");
		
		List<Prenda> listaPrenda = List.of(prenda1, prenda2);
		
		GuardaRopa guardarRopa = new GuardaRopa();
		
		int id = guardarRopa.guardarPrendas(listaPrenda);
		
		System.out.println(guardarRopa.devolverPrendas(id));
		
	}

}

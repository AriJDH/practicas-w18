package sabetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
	
	

	public GuardaRopa() {
		super();
	}

	private HashMap<Integer, List<Prenda>> list = new HashMap<>();
	private static int id = 0;

	public Integer guardarPrendas(List<Prenda> listaDePrendas) {
		
		++id;

		list.put(id, listaDePrendas);

		return id;
	}
	
	public void mostrarPrendas() {
		
		for(Map.Entry<Integer, List<Prenda>> entry : list.entrySet()) {
			
			entry.getValue().stream().forEach(p -> {
				System.out.println(entry.getKey() + " " + p.getMarca() + " " + p.getModelo());
			});
			
		}
		
	}

	public List<Prenda> devolverPrendas(Integer numero){
		
		return list.get(numero);
		
		
	}
}

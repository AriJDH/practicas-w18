package recapitulandojava;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
	
	
	public Garaje(int id, List<Vehiculo> vehiculos) {
		super();
		this.id = id;
		this.vehiculos = vehiculos;
	}

	private int id;
	
	private List<Vehiculo> vehiculos = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	

}

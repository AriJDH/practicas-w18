package dakar;

import java.util.List;

public class Carrera {

	public Carrera(double distancia, double premio, String nombre, int cantidadDeVehiculosPermitidos,
			List<Vehiculo> vehiculos) {
		super();
		this.distancia = distancia;
		this.premio = premio;
		this.nombre = nombre;
		this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
		this.vehiculos = vehiculos;
	}

	private double distancia;
	private double premio;
	private String nombre;
	private int cantidadDeVehiculosPermitidos;
	private List<Vehiculo> vehiculos;
	
	public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
		
		Autos auto = new Autos(velocidad, aceleracion, anguloDeGiro, patente);
		if(cantidadDeVehiculosPermitidos < vehiculos.size())
		{
			vehiculos.add(auto);
		}
	}
	
	public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
		
		Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
		if(cantidadDeVehiculosPermitidos < vehiculos.size())
		{
			vehiculos.add(moto);
		}
	}

	public void eliminarVehiculo(Vehiculo vehiculo) {
		vehiculos.remove(vehiculo);
	}
	
	public void eliminarVehiculoContPatente(String patente) {
		for(Vehiculo ve : vehiculos) {
			if(ve.getPatente().equals(patente))
				vehiculos.remove(ve);
		}
	}
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getPremio() {
		return premio;
	}

	public void setPremio(double premio) {
		this.premio = premio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadDeVehiculosPermitidos() {
		return cantidadDeVehiculosPermitidos;
	}

	public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
		this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

}

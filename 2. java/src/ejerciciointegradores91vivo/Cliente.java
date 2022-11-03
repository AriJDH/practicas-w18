package ejerciciointegradores91vivo;

public class Cliente {
	
	
	public Cliente(String nombre, int cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	private String nombre;
	private int cedula;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", cedula=" + cedula;
	}
	
	

}

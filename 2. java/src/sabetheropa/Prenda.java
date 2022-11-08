package sabetheropa;

public class Prenda {
	
	
	
	public Prenda(String modelo, String marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
	}
	private String modelo;
	private String marca;
	
	
	
	@Override
	public String toString() {
		return "Prenda [modelo=" + modelo + ", marca=" + marca + "]";
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

}

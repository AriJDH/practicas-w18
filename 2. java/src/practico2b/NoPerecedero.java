package practico2b;

public class NoPerecedero extends Producto{
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}
	
	@Override
	double calcular(int cantidad) {
		return super.calcular(cantidad);
	}

	public NoPerecedero(String nombre, double precio , String tipo) {
		super(nombre, precio);
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		return "NoPerecedero [tipo=" + tipo + "]";
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}

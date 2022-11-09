package model;

public class Comida extends Reservable{
	
	// Constructores
	public Comida() {
	}
	
	public Comida(Double precioUnitario, Double precioTotal, Double descuentoAplicado) {
		super(precioUnitario, precioTotal, descuentoAplicado);
	}
	
	// Métodos
	@Override
	public void calcularPrecio(Integer cantidad) {
		Double precioTotal = getPrecioUnitario() * cantidad;
		setPrecioTotal(precioTotal);
	}
}

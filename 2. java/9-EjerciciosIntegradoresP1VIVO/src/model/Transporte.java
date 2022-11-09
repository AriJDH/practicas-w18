package model;

public class Transporte extends Reservable{
	
	// Constructores
	public Transporte() {
	}
	
	public Transporte(Double precioUnitario, Double precioTotal, Double descuentoAplicado) {
		super(precioUnitario, precioTotal, descuentoAplicado);
	}
	
	// Métodos
	@Override
	public void calcularPrecio(Integer cantidad) {
		Double precioTotal = getPrecioUnitario() * cantidad;
		setPrecioTotal(precioTotal);
	}
}

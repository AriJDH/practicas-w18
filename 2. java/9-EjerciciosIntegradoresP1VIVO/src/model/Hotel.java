package model;

public class Hotel extends Reservable implements IDescuento<Integer>{
	
	// Constructores
	public Hotel() {
	}
	
	public Hotel(Double precioUnitario, Double precioTotal, Double descuentoAplicado) {
		super(precioUnitario, precioTotal, descuentoAplicado);
	}
	
	// Métodos
	@Override
	public void calcularPrecio(Integer cantidad) {
		Double precioTotal = getPrecioUnitario() * cantidad;
		setPrecioTotal(precioTotal);
	}
	
	@Override
	public void calcularDescuento(Integer cantidad) {
		if (cantidad == 2) {
			Double descuentoAplicado = getPrecioTotal() * 0.05;
			setDescuentoAplicado(descuentoAplicado);
		}
	}
}

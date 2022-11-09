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
		calcularDescuento(cantidad);
		Double totalConDescuento = precioTotal - getDescuentoAplicado();
		setPrecioTotal(totalConDescuento);
	}
	
	@Override
	public void calcularDescuento(Integer cantidad) {
		if (cantidad == 2) {
			Double descuentoAplicado = getPrecioTotal() * 0.05;
			setDescuentoAplicado(descuentoAplicado);
		}
	}
}

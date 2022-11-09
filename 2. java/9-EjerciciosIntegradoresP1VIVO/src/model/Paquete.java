package model;

import java.util.List;

public class Paquete extends Reservable implements IDescuento<Boolean>{
	
	// Atributos
	private List<Reservable> reservableList;
	
	// Constructores
	public Paquete(List<Reservable> reservableList) {
		this.reservableList = reservableList;
	}
	
	public Paquete(Double precioUnitario,
	               Double precioTotal,
	               Double descuentoAplicado,
	               List<Reservable> reservableList) {
		super(precioUnitario, precioTotal, descuentoAplicado);
		this.reservableList = reservableList;
	}
	
	// Métodos
	public void agregarReservable(Reservable reservable){
		reservableList.add(reservable);
	}
	
	@Override
	public void calcularPrecio(Integer cantidad) {
		Double precioTotal = getPrecioUnitario() * cantidad;
		setPrecioTotal(precioTotal);
	}
	
	@Override
	public void calcularDescuento(Boolean completo) {
		if(completo){
			Double descuentoAplicado = getPrecioTotal() * 0.10;
			setDescuentoAplicado(descuentoAplicado);
		}
	}
}

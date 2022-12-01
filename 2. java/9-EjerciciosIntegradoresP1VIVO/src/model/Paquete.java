package model;

import org.w3c.dom.DOMImplementation;

import java.util.ArrayList;
import java.util.List;

public class Paquete extends Reservable implements IDescuento<Boolean> {
	
	// Atributos
	private List<Reservable> reservableList = new ArrayList<>();
	
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
	public void agregarReservable(Reservable reservable) {
		reservableList.add(reservable);
	}
	
	@Override
	public void calcularPrecio(Integer cantidad) {
		Double precioTotal = calcularPrecioUnitario() * cantidad;
		setPrecioTotal(precioTotal);
	}
	
	@Override
	public void calcularDescuento(Boolean completo) {
		if (completo) {
			Double descuentoAplicado = getPrecioTotal() * 0.10;
			setDescuentoAplicado(descuentoAplicado);
		}
	}
	
	private Double calcularPrecioUnitario() {
		Double precioUnitario = 0.0;
		for (Reservable reservable :
						reservableList) {
			precioUnitario += reservable.getPrecioTotal();
		}
		setPrecioUnitario(precioUnitario);
		return precioUnitario;
	}
}

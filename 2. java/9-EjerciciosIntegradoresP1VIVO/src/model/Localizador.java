package model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
	
	// Atributos
	private Long id;
	private Cliente cliente;
	private List<Reservable> reservableList = new ArrayList<>();
	private Double precioTotal;
	private Double descuentoAplicado;
	
	// Constructores
	public Localizador() {
	}
	
	public Localizador(Long id,
	                   Cliente cliente,
	                   List<Reservable> reservableList,
	                   Double precioTotal,
	                   Double descuentoAplicado) {
		this.id = id;
		this.cliente = cliente;
		this.reservableList = reservableList;
		this.precioTotal = precioTotal;
		this.descuentoAplicado = descuentoAplicado;
	}
	
	// Getters y setters
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Reservable> getReservableList() {
		return reservableList;
	}
	
	public void setReservableList(List<Reservable> reservableList) {
		this.reservableList = reservableList;
	}
	
	public Double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public Double getDescuentoAplicado() {
		return descuentoAplicado;
	}
	
	public void setDescuentoAplicado(Double descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	// Métodos
	@Override
	public String toString() {
		return "Este localizador está formado por: " +
						"\n Cliente ID: " + cliente.getId() +
						"\n Listado de Reservas: " + reservableList +
						"\n Precio Total: " + precioTotal +
						"\n Descuento Aplicado: " + descuentoAplicado;
	}
	
	public void agregarReservable(Reservable reservable, Integer cantidad){
		reservable.calcularPrecio(cantidad);
		reservableList.add(reservable);
	}
}

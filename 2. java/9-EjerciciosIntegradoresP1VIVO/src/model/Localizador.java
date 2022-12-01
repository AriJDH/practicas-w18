package model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
	
	// Atributos
	private Long id = 0L;
	private Long clienteId;
	private List<Reservable> reservableList = new ArrayList<>();
	private Double precioTotal = 0.0;
	private Double descuentoAplicado = 0.0;
	
	// Constructores
	public Localizador() {
		this.id +=1 ;
	}
	
	public Localizador(Long id,
	                   Long clienteId,
	                   List<Reservable> reservableList,
	                   Double precioTotal,
	                   Double descuentoAplicado) {
		this.id = id;
		this.clienteId = clienteId;
		this.reservableList = reservableList;
		this.precioTotal = precioTotal;
		this.descuentoAplicado = descuentoAplicado;
	}
	
	public Localizador(long id, Long clienteId) {
		this.id = id;
		this.clienteId = clienteId;
	}
	
	// Getters y setters
	public Long getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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
						"\n Cliente ID: " + clienteId +
						"\n Listado de Reservas: " + reservableList +
						"\n Precio Total: " + precioTotal +
						"\n Descuento Aplicado: " + descuentoAplicado;
	}
	
	public void agregarReservable(Reservable reservable, Integer cantidad){
		reservable.calcularPrecio(cantidad);
		reservableList.add(reservable);
		setPrecioTotal(precioTotal+reservable.getPrecioTotal()*cantidad);
	}
}

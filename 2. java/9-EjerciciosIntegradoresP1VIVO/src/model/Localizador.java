package model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
	
	// Atributos
	private Cliente cliente;
	private List<Reservable> reservableList = new ArrayList<>();
	private Double precioTotal;
	private Double descuentoAplicado;
	
	// Constructores
	public Localizador() {
	}
	
	public Localizador(Cliente cliente, List<Reservable> reservableList, Double precioTotal,
	                   Double descuentoAplicado) {
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
		// Antes de agregar las reservas tiene que calcular los precios y los descuentos
		/* TODO
		--> Si es un boleto de viaje y son 2 reservas = 5% descuento
		--> Si es un paquete completo = 10% descuento
		--> Si el cliente tiene más de 2 localizadores = 5% descuento
		 */
		// Una vez aplicados los descuentos, se setea el precio total del Localizador
		reservableList.add(reservable);
	}
	
	
	// TODO crear repositorio para localizadores
}

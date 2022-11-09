package model;

public abstract class Reservable {
	
	// Atributos
	private Double precioUnitario;
	private Double precioTotal;
	private Double descuentoAplicado;
	
	// Constructores
	public Reservable() {
	}
	
	public Reservable(Double precioUnitario,
	                  Double precioTotal,
	                  Double descuentoAplicado) {
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
		this.descuentoAplicado = descuentoAplicado;
	}
	
	// Getters y setters
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
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
		return "Reserva tipo " + this.getClass().getSimpleName() +
						"\n Precio Unitario:" + precioUnitario +
						"\n Precio Total: " + precioTotal +
						"\n Descuento Aplicado:" + descuentoAplicado;
	}
	
	public abstract void calcularPrecio(Integer cantidad);
}

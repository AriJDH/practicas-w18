package supermercado.elconomico;

import java.util.List;

public class Factura {

	public Factura(Cliente cliente, List<Item> items, double total) {
		super();
		this.cliente = cliente;
		this.items = items;
		this.total = total;
	}

	private Cliente cliente;
	private List<Item> items;
	private double total;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}

package supermercado_el_economico.clases;

import supermercado_el_economico.interfaces.IFacturaCrud;

import java.util.List;

public class Factura implements IFacturaCrud {

    private Cliente cliente;

    private List<Item> items;

    private Double totalCompra;

    public Factura() {
        this.totalCompra = 0.0;
    }

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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public void calcularTotalFactura() {

        for (Item item : items) {
            this.totalCompra += item.obtenerValorTotal();
        }
    }

    @Override
    public void crearFactura(Cliente cliente, List<Item> items) {

        this.cliente = cliente;

        this.items = items;

        calcularTotalFactura();
    }

    @Override
    public void consultarFactura() {
        //No se implementa
    }

    @Override
    public void eliminarFactura() {
        //No se implementa
    }

    @Override
    public void modificarFactura() {
        //No se implementa
    }

    @Override
    public String toString() {
        return "Factura{" +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}

package SuperMercadoEconomico.Clases;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private Double totalCompra;
    private List<Item> item;
    private Long codigo;

    public Factura(Cliente cliente, List<Item> item, Long codigo) {
        setCliente(cliente);
        setItem(item);
        setCodigo(codigo);
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotalCompra() {
        this.setTotalCompra(item.stream().mapToDouble(s-> s.getCosto() * s.getCantidad()).sum());
        return this.totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", totalCompra=" + totalCompra +
                ", item=" + item +
                '}';
    }
}

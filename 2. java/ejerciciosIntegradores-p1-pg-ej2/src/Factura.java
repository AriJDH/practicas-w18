import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> itemArrayList;
    private Double totalCompra;

    public Factura(Cliente cliente, ArrayList<Item> itemArrayList) {
        this.cliente = cliente;
        this.itemArrayList = itemArrayList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void calcularTotalCompra() {

    }
}

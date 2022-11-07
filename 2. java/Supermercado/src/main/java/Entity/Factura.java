package Entity;

import java.util.Arrays;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente){
        this.cliente = cliente;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void addItem(Item ...item){
        items.addAll(Arrays.asList(item));
    }

    public void calcularTotal(){
        setTotal(items
                .stream()
                .mapToDouble(Item::calcularTotal)
                .sum());
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

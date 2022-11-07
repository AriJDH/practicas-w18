import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Factura implements Icrud<Factura>{
    Cliente cliente;
    int numero;
    List<Item> items;
    double total;

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Factura(Cliente cliente, int numero, List<Item> items, double total) {
        this.cliente = cliente;
        this.numero = numero;
        this.items = items;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", numero=" + numero +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    @Override
    public void guardar(Factura obj, List<Factura> lista) {
        lista.add(obj);
    }

    @Override
    public void borrar(Factura obj, List<Factura> lista) {
        List<Factura> aux = new ArrayList<Factura>();
        aux.addAll(lista);
        for(int i=0; i< aux.size(); i++){
            if(aux.get(i).numero == obj.getNumero())
                lista.remove(aux.get(i));
        }
    }

    @Override
    public boolean buscar(int id, List<Factura> lista) {
        int band =0;
        for(Factura c: lista){
            if(c.numero == id){
                band=1;
                System.out.println(c.toString());
                return true;
            }
        }
        if(band ==0)
            System.out.println("No existe una factura con el nùmero ingresado");
        return false;

    }
}

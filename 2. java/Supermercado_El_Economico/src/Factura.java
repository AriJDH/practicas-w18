import java.util.ArrayList;

public class Factura {

    private Cliente cliente;
    ArrayList<Item> items;
    private double total_Compra;

    public Factura(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        this.items = items;
        calcularTotal();
    }


    private void calcularTotal(){
        double total = 0;
        for (Item item:this.items){
            total += item.getCantidad() * item.getCosto_unitario();
        }
        this.total_Compra = total;
    }
}

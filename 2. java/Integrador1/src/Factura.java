import java.util.ArrayList;

public class Factura {

    ArrayList<Factura>facturas = new ArrayList<>();

    private double total;
    private Cliente cliente;
    ArrayList<Producto> productos = new ArrayList<>();

    public Factura(Cliente cliente, ArrayList<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    void crearFactura(Factura f1, ArrayList dbCliente){
        Cliente c = f1.cliente;

        boolean check = dbCliente.contains(c);

        if (check) facturas.add(f1);
        else dbCliente.add(c);

        calcularTotal();
    }

    void calcularTotal(){
        productos.stream()
                .forEach(producto -> {
                    total += producto.getCosto() * producto.getCantidad();
                });
    }

    @Override
    public String toString() {
        return "Factura{" +
                " total =" + total +
                ",cliente =" + cliente +
                ",productos =" + productos +
                '}';
    }
}

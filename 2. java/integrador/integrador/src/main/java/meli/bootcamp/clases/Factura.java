package meli.bootcamp.clases;

import java.util.ArrayList;
import java.util.Collection;

public class Factura {
    private Cliente cliente;
    private ArrayList<DetalleFactura> detalle;
    private double totalCompra;

    public Factura()
    {
        detalle = new ArrayList<>();
    }

    public double getPrecio() {
        return totalCompra;
    }

    public void setCliente(Cliente cliente, Collection<Cliente> clientes)
    {
        if (clientes.stream().anyMatch(x -> x.getDni().equals(cliente.getDni())))
        {
            this.cliente = cliente;
            System.out.println("El CLIENTE SE HA ASOCIADO CORRECTAMENTE A LA FACTURA");
            return;
        }
        System.out.println("EL CLIENTE NO SE ENCUENTRA EN LA COLECCION");
    }

    public void setDetalle(ArrayList<DetalleFactura> detalle)
    {
        this.detalle = detalle;
    }

    public void setPrecio()
    {
        double total = 0;
        for (DetalleFactura df :
                detalle) {
            total += df.getCtdProducto() * df.getItem().getPrecio();
        }
        totalCompra = total;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Factura{");
        sb.append("cliente=").append(cliente);
        sb.append(", detalle=").append(detalle);
        sb.append(", totalCompra=").append(totalCompra);
        sb.append('}');
        return sb.toString();
    }
}

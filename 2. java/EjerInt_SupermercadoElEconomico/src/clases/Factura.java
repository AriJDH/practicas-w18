package clases;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Linea> lineas;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Linea> lineas) {
        this.lineas = lineas;
    }

    public double getTotal(){
        return this.lineas.stream().mapToDouble(l -> l.obtenerSubtotalLinea()).sum();
    }

    public Factura(Cliente cliente, ArrayList<Linea> lineas) {
        this.cliente = cliente;
        this.lineas = lineas;
    }
}

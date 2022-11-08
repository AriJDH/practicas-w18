package clases;

import java.util.ArrayList;

public class Factura {

    private static Integer numeroProximaFactura = 1;
    private Integer numeroFactura;
    private Cliente cliente;
    private ArrayList<Linea> lineas;

    public Factura(Cliente cliente, ArrayList<Linea> lineas) {
        this.cliente = cliente;
        this.lineas = lineas;
        this.numeroFactura = numeroProximaFactura++;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroFactura(){
        return this.numeroFactura;
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

    @Override
    public String toString() {
        String detalle = "";
        for (Linea l:lineas) {
            detalle += "   "+l.toString()+"\n";
        }
        return "Factura numero: " + numeroFactura +".\n  "+ cliente +"\n  Detalle:  \n"+ detalle + "  Total: $"+getTotal();
    }
}

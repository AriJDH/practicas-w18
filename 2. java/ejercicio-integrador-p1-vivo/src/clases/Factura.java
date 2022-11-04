package clases;

import java.util.List;

public class Factura {
    private List<Reserva> listReservas;
    private double total;

    public Factura() {
    }

    public Factura(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

    public List<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "listReservas=" + listReservas +
                ", total=" + total +
                '}';
    }

    public double calcularTotalFactura(){
        double totalFactura = 0.0;
        for(Reserva re : listReservas){
            totalFactura += re.getPrecio();
        }
        return totalFactura;
    }
}

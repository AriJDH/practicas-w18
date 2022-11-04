package clases;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private ArrayList<Reserva> reservas;
    private Cliente cliente;
    private double descuentoBase;

    private double descuentoTotal;

    public Localizador(ArrayList<Reserva> reservas, Cliente cliente, double descuentoBase) {
        this.reservas = reservas;
        this.cliente = cliente;
        this.descuentoBase = descuentoBase;
        this.descuentoTotal = obtenerDescuentoTotal();
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDescuento() {
        return descuentoBase;
    }

    public void setDescuento(double descuento) {
        this.descuentoBase = descuento;
    }

    public double obtenerTotal(){
        return reservas.stream().mapToDouble(r -> r.getCantidad()*r.getCosto()).sum() * (1.0 - this.descuentoTotal);
    }

    private double obtenerDescuentoTotal(){
        int comidas = 0;
        int transportes = 0;
        int hoteles = 0;
        int boletosViajes= 0;

        double descuentoTotal = this.descuentoBase;

        for (Reserva r: reservas) {
            if(r instanceof Comida){
                comidas+= r.getCantidad();
            }else if(r instanceof Transporte){
                transportes+= r.getCantidad();
            }else if(r instanceof  Hotel){
                hoteles += r.getCantidad();
            }else if(r instanceof BoletosViaje){
                boletosViajes += r.getCantidad();
            }
        }

        if(hoteles > 0 && comidas > 0 && transportes > 0 && boletosViajes > 0)descuentoTotal += 0.10;
        if(hoteles >= 2 || boletosViajes >= 2)descuentoTotal += 0.05;

        return descuentoTotal;
    }

    @Override
    public String toString() {
        String res = "Detalle Localizador: \n" +"   "+this.cliente.toString()+"\n"+
        reservas.stream().map(r -> "     "+r.toString()).reduce("", String::concat)+
                "   Descuento aplicado: %"+this.descuentoTotal*100 + "\n   Total: $"+obtenerTotal();

        return res;
    }
}

package clases;

import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private ArrayList<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public double obtenerPrecioTotal(){
        double total = 0;
        for (Reserva r:this.reservas) {
            total += r.getPrecio();
        }
        return total;
    }
}

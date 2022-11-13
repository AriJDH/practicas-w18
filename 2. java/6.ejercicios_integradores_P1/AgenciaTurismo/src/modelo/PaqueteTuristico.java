package modelo;

import java.util.List;

public class PaqueteTuristico extends TipoReserva{
    private List<TipoReserva> reservas;

    private PaqueteTuristico(String idNombre, Double precio) {
        super(idNombre, precio);
    }

    public PaqueteTuristico(String nombre, List<TipoReserva> listaReservas){
        this(nombre, getTotalPaquete(listaReservas));
        this.reservas = listaReservas;
    }

    private static Double getTotalPaquete(List<TipoReserva> listaReservas) {
        return listaReservas.stream().mapToDouble(r ->r.getPrecio()).sum();
    }

    @Override
    public String toString() {
        return "Paquete Turístico: " + super.toString();
    }
}

package clase4_b_EjerciciosIntegrador.modelo;

import java.util.List;

public class ReservaBoletoDeViaje extends TipoReserva{
    public ReservaBoletoDeViaje(String idNombre, Double precio) {
        super(idNombre, precio);
    }

    public static class Localizador {
        private Cliente cliente;
        private Double total;
        private List<TipoReserva> reservas;
    }
}

import java.util.List;

public class Localizador {
    List<Paquete> reservas;
    Double total = 0.0;
    Cliente cliente;

    public Localizador(List<Paquete> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }

    public void calcularTotal() {
        for (Paquete reserva : reservas) {
            total = total + reserva.getCosto();
        }
    }

}

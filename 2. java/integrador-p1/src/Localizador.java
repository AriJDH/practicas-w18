import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {

        this.total = calculaTotal(reservas);
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public double calculaTotal(List<Reserva> reservas){
        double total = reservas.stream().mapToDouble(x -> x.getCosto()).sum();
        return total;
    }


    public void agregaReserva(Reserva reserva){
        int counterHotel = 0;
        int counterBoleto = 0;
        reservas.add(reserva);

        for (Reserva reservaCargada :this.reservas) {
            if (reservaCargada instanceof ReservaHotel){
                counterHotel++;
                if (counterHotel >= 2 && reservaCargada instanceof ReservaHotel){
                    ((ReservaHotel) reservaCargada).setDescuentoDelCinco(true);
                }
            }
            if (reservaCargada instanceof ReservaBoleto){
                counterBoleto++;
                if (counterBoleto >= 2 && reservaCargada instanceof ReservaBoleto){
                    ((ReservaBoleto) reservaCargada).setDescuentoDelCinco(true);
                }
            }
        }


    }

    public double getTotal() {

        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "\n cliente=" + cliente +
                "\n, reservas=" + reservas +
                "\n, total=" + total +
                '}';
    }
}

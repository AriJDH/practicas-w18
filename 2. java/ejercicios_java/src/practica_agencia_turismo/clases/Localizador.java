package practica_agencia_turismo.clases;

import practica_agencia_turismo.interfaces.ILocalizador;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements ILocalizador {

    private List<Reserva> reservas;

    private Double total;

    public Localizador() {

        this.reservas = new ArrayList<>();
        this.total = 0.0;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void calcularPaqueteCompleto() {

        boolean reservaComida = false, reservaBoletosViaje = false, reservaHotel = false, reservaTransporte = false;

        for (Reserva reserva : reservas) {

            if (reserva instanceof ReservaComida) {
                reservaComida = true;
            }

            if (reserva instanceof ReservaBoletosViaje) {
                reservaBoletosViaje = true;
            }

            if (reserva instanceof ReservaHotel) {
                reservaHotel = true;
            }

            if (reserva instanceof ReservaTransporte) {
                reservaTransporte = true;
            }
        }

        calcularTotalReservas();

        if (reservaComida && reservaHotel && reservaTransporte && reservaBoletosViaje) {
            setTotal(getTotal() - (getTotal() * 0.10));
        }
    }

    private void calcularTotalReservas() {
        for (Reserva reserva : reservas) {
            this.total += reserva.getValorReserva();
        }
    }

    public void aplicar5Porciento() {
        setTotal(getTotal() - (getTotal() * 0.05));
    }

    public void aplicarDescuentoReservaHotelViaje() {

        int cantidadReservasHotel = 0;
        int cantidadReservasViaje = 0;

        for (Reserva reserva : reservas) {


            if (reserva instanceof ReservaBoletosViaje) {
                cantidadReservasViaje += 1;
            }

            if (reserva instanceof ReservaHotel) {
                cantidadReservasHotel += 1;
            }
        }

        if (cantidadReservasHotel == 2
            && cantidadReservasViaje == 2) {

            Double descuentoReservas = 0.0;

            for (Reserva reserva : reservas) {

                if (reserva instanceof ReservaBoletosViaje) {
                    descuentoReservas += (reserva.getValorReserva() * 0.05);
                }

                if (reserva instanceof ReservaHotel) {
                    descuentoReservas += (reserva.getValorReserva() * 0.05);
                }
            }

            setTotal(getTotal() - descuentoReservas);
        }
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}

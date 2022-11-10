package AgenciaDeTurismo.Repository;

import AgenciaDeTurismo.Clases.Reserva;
import AgenciaDeTurismo.Interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaCrud implements CrudRepository<Reserva> {
    List<Reserva> listaReserva = new ArrayList<>();

    @Override
    public void save(Reserva objeto) {
        listaReserva.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (AgenciaDeTurismo.Clases.Reserva r : listaReserva) {
            System.out.println("Reserva: " + (r.isHotel()?"Con Hotel": "Sin Hotel"));
            System.out.println("Reserva: " + (r.isBoletos()?"Con Boletos": "Sin Boletos"));
            System.out.println("Reserva: " + (r.isComida()?"Con Comida": "Sin Comida"));
            System.out.println("Reserva: " + (r.isTransporte()?"Con Transporte": "Sin Transporte"));
            System.out.println("Código Reserva: " + r.getCodigoReserva());
            System.out.println("Valor Reserva: " + r.getCostoReserva());
        }
    }

    @Override
    public Optional<Reserva> buscar(Long reservaBuscada) {
        boolean bandera = false;
        for (AgenciaDeTurismo.Clases.Reserva r : listaReserva) {
            if (r.getCodigoReserva() == reservaBuscada) {
                System.out.println("----Reserva encontrada, sus datos son: ----");
                System.out.println(r.toString());
                return Optional.of(r);
            }
        }

        if (!bandera) {
            System.out.println("Cliente no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<AgenciaDeTurismo.Clases.Reserva> rse = this.buscar(id);

        if (rse.isEmpty()) {
            System.out.println("No se encontró la reserva a borrar");
        }
        else {
            System.out.println("reserva borrado correctamente");
            listaReserva.remove(rse.get());
        }
    }

    @Override
    public List<Reserva> traerTodos() {
        return listaReserva;
    }
}

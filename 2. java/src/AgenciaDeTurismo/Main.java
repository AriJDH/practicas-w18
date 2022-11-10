package AgenciaDeTurismo;

import AgenciaDeTurismo.Clases.Cliente;
import AgenciaDeTurismo.Clases.Localizador;
import AgenciaDeTurismo.Clases.Reserva;
import AgenciaDeTurismo.Repository.ClienteCrud;
import AgenciaDeTurismo.Repository.LocalizadorCrud;
import AgenciaDeTurismo.Repository.ReservaCrud;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Pepito Perez", "112512521");
        ClienteCrud clienteCrud = new ClienteCrud();
        clienteCrud.save(cliente1);
        clienteCrud.mostrarPantalla();

        Reserva reservaUnoCliente1 = new Reserva(true,true, true, true, 2500000.00);
        ReservaCrud reservaCrudCliente1 = new ReservaCrud();
        reservaCrudCliente1.save(reservaUnoCliente1);
        reservaCrudCliente1.mostrarPantalla();

        Localizador localizadorReservaUnoCliente1 = new Localizador(cliente1,reservaCrudCliente1.traerTodos());
        Localizador localizadorReservaDosCliente1 = new Localizador(cliente1,reservaCrudCliente1.traerTodos());
        LocalizadorCrud localizadorCrudCliente1 = new LocalizadorCrud();
        localizadorCrudCliente1.save(localizadorReservaUnoCliente1);
        localizadorCrudCliente1.save(localizadorReservaDosCliente1);
        localizadorCrudCliente1.mostrarPantalla();

    }
}

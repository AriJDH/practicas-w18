import clases.Cliente;
import clases.Factura;
import clases.Reserva;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Reserva reserva1 = new Reserva(1, "Hotel",45000.0);
        ArrayList<Reserva> listaDeReservas= new ArrayList<>();
        listaDeReservas.add(reserva1);
        Factura factura1 = new Factura(listaDeReservas);
        ArrayList<Factura> listaDeFacturas= new ArrayList<>();
        listaDeFacturas.add(factura1);
        Cliente cliente1= new Cliente(listaDeFacturas, "Pepe", "Perez", "12343");
    }
}
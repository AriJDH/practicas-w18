package meli.bootcamp;

import meli.bootcamp.clases.Cliente;
import meli.bootcamp.clases.Consultas;
import meli.bootcamp.clases.Localizador;
import meli.bootcamp.clases.Reserva;
import meli.bootcamp.repositories.RepositorioCliente;
import meli.bootcamp.repositories.RepositorioLocalizador;

import static meli.bootcamp.repositories.RepositorioCliente.*;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RepositorioLocalizador a = new RepositorioLocalizador();
        RepositorioCliente b = new RepositorioCliente();

        Cliente c = new Cliente(1);
        Reserva r = new Reserva(1, true,true,true,true);
        Localizador l = new Localizador(2000);
        c.agregarLocalizador(l);
        l.agregarReserva(r);
        a.saveLocalizador(l);
        a.mostrarDetallesCompra(l);
        b.aplicarDescuento(c,l);

        System.out.println();
        Reserva r1 = new Reserva(1, true,false,true,false);
        Reserva r2 = new Reserva(1, true,false,true,false);
        Localizador l2 = new Localizador(3500);
        c.agregarLocalizador(l2);
        l2.agregarReserva(r1);
        l2.agregarReserva(r2);
        a.saveLocalizador(l2);
        a.mostrarDetallesCompra(l2);
        b.aplicarDescuento(c,l2);

        System.out.println();
        Reserva r3 = new Reserva(1,true,true,true,false);
        Localizador l3 = new Localizador(1000);
        c.agregarLocalizador(l3);
        l3.agregarReserva(r3);
        a.saveLocalizador(l3);
        a.mostrarDetallesCompra(l3);
        b.aplicarDescuento(c,l3);

        Consultas con = new Consultas();
        con.addCliente(c);
        System.out.println(con.getCantidadLocalizadores());
        System.out.println(con.getCantitadReservas());
        System.out.println(con.getTotalVentas());
        System.out.println(con.getPromedioVentas());
    }
}

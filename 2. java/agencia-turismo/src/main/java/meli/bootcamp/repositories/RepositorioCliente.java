package meli.bootcamp.repositories;

import meli.bootcamp.clases.Cliente;
import meli.bootcamp.clases.Localizador;
import meli.bootcamp.clases.Reserva;

public class RepositorioCliente {

    public void reservasAnteriores(Cliente cliente)
    {
        for (Localizador l:
             cliente.getLocalizadores()) {
            l.mostrarReservas();
        }
    }
    
    public void aplicarDescuento(Cliente cliente, Localizador localizador)
    {
        if (cliente.getLocalizadores().size() >= 2)
        {
            System.out.println("APLICAR 5% POR TENER 2 LOC");
        }
        if (localizador.tieneAlgunPaqueteCompleto()){
            System.out.println("APLICAR 10% PAQ CMP");
        }
        if (localizador.tieneDobleHotelViaje()){
            System.out.println("APLICAR 5% DOBLE VIAJE O HOTEL");
        }
    }
}

package com.meli.lgutierrez.clase4.tarde.agenciaTurismo.repositorio;

import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.Cliente;
import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.Localizador;

import java.util.List;

public class RepositorioCliente {

        public void agregarLocalizador(Cliente cliente, Localizador localizador){
            List<Localizador> l = cliente.getLocalizadores();
            l.add(localizador);
            System.out.println("El localizador fue agregado al cliente " + cliente.getNombre() + " exitosamente");
        }

        public void guardarCliente(Cliente cliente){
            System.out.println("Se ha guardao el cliente " + cliente.getNombre() +" correctamente");
        }

        public void mostrarReservas(Cliente cliente){
            System.out.println("\nEl cliente " + cliente.getNombre() + " tiene los siguientes localizadores:");
            cliente.getLocalizadores().stream().forEach(System.out::println);
            descuentoLocalizadores(cliente);
        }

        public void descuentoLocalizadores(Cliente cliente){
            if (cliente.getLocalizadores().size() >= 2){
                System.out.println("\nFelicitaciones!!!");
                System.out.println("Ganó un descuento del 5% para su próxima compra. CODIGO: DJHFJHDSJ ");
            }
        }
}

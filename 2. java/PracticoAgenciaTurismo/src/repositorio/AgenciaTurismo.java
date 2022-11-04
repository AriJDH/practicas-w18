package repositorio;

import clases.*;

import java.util.ArrayList;
import java.util.Collections;

public class AgenciaTurismo {
    private ArrayList<Cliente> clientes;
    private ArrayList<Localizador> localizadores;

    public AgenciaTurismo() {
        this.clientes = new ArrayList<Cliente>();
        this.localizadores = new ArrayList<Localizador>();
    }

    public void agregarCliente(String nombre){
        Cliente nuevo = new Cliente(nombre);
        clientes.add(nuevo);
    }

    public void agregarLocalizador(Localizador l){
        localizadores.add(l);
    }

    public void preCargaDatos(){
        Cliente nico = new Cliente("Nico");
        Cliente vane = new Cliente("Vane");
        Cliente ruso = new Cliente("Ruso");
        Cliente ariel = new Cliente("Ariel");

        Collections.addAll(clientes, nico, vane, ruso, ariel);
    }

    public void ejecutarParte1(){
        Cliente cli = new Cliente("Flamante Cliente");

        ArrayList<Reserva> reservasL1 = new ArrayList<>();
        reservasL1.add(new BoletosViaje("Pasajes aéreos Miami", 1000, 1));
        reservasL1.add(new Hotel("3 noches en Hotel 5 estrellas", 500, 1));
        reservasL1.add(new Comida("Cena en Hotel", 200, 1));
        reservasL1.add(new Transporte("Taxi a Museo", 100, 1));
        Localizador l1 = new Localizador(reservasL1, cli, obtenerDescuentoBaseCliente(cli.getId()));
        localizadores.add(l1);
        System.out.println(l1+"\n------------------------------------------------------------------");

        ArrayList<Reserva> reservasL2 = new ArrayList<>();
        reservasL2.add(new BoletosViaje("Pasaje Buquebus a Buenos Aires", 500, 2));
        reservasL2.add(new Hotel("5 noches en Hotel 4 estrellas", 500, 2));
        Localizador l2 = new Localizador(reservasL2, cli, obtenerDescuentoBaseCliente(cli.getId()));
        localizadores.add(l2);
        System.out.println(l2+"\n------------------------------------------------------------------");

        ArrayList<Reserva> reservasL3 = new ArrayList<>();
        reservasL3.add(new BoletosViaje("Pasajes aéreos Barcelona", 1000, 1));
        Localizador l3 = new Localizador(reservasL3, cli, obtenerDescuentoBaseCliente(cli.getId()));
        localizadores.add(l3);
        System.out.println(l3+"\n------------------------------------------------------------------");

    }

    public double obtenerDescuentoBaseCliente(int idCliente){
        long cantidadLocalizadoresCliente = localizadores.stream()
                .filter(l -> l.getCliente().getId() == idCliente)
                .count();

        return cantidadLocalizadoresCliente >= 2? 0.05 : 0;
    }
}

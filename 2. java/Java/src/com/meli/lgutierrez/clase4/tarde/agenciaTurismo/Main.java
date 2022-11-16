package com.meli.lgutierrez.clase4.tarde.agenciaTurismo;

public class Main {
    public static void main(String[] args) {

        //Parte 1 (punto1)
        System.out.println("\n----------------------- Punto 1 -----------------------\n");
        Reserva r1 = new Reserva(true, true, true, true, 5000D);

        Cliente cliente1 = new Cliente("Laura");
        cliente1.guardarCliente();

        Localizador localizador1 = new Localizador();
        cliente1.agregarLocalizador(localizador1);

        localizador1.agregarReserva(r1);
        cliente1.mostrarReservas();

        System.out.println("\n----------------------- Punto 2 -----------------------\n");

        //Parte 1 (punto2)
        Reserva r2 = new Reserva(true, true, false, false, 2000D);
        Reserva r3 = new Reserva(true, true, false, false, 2000D);

        Cliente cliente2 = new Cliente("Jhon");
        cliente2.guardarCliente();
        Localizador localizador2 = new Localizador();
        cliente2.agregarLocalizador(localizador2);

        localizador2.agregarReserva(r2);
        localizador2.agregarReserva(r3);
        cliente2.mostrarReservas();

        System.out.println("\n----------------------- Punto 3 -----------------------\n");

        //Parte 1 (punto3)
        Localizador localizador3 = new Localizador();
        Reserva r4 = new Reserva(true, false, false, false, 1000D);
        localizador3.agregarReserva(r4);
        cliente2.agregarLocalizador(localizador3);
        cliente2.mostrarReservas();

        System.out.println("\n----------------------- Consultas -----------------------\n");

        Consulta consulta = new Consulta();
        consulta.getClientes().add(cliente1);
        consulta.getClientes().add(cliente2);

        System.out.println("La cantidad de localizadores es: " + consulta.consultarLocalizadores());
        System.out.println("La cantidad de reservas es: " + consulta.consultarReservas());
        System.out.println("El total de las ventas es $: " + consulta.consultarVentas());
        System.out.println("El promedio de las ventas es $: " + consulta.promedioVentas());
        System.out.println("Los tipos de reseva son: " + consulta.clasificacionReservas());

    }
}

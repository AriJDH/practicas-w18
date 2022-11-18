package agencia_turismo;

import agencia_turismo.Repositories.ListRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ListRepository<Cliente> clientRepository = new ListRepository<>();
    private static ListRepository<Localizador> localizadorRepository = new ListRepository<>();

    public static void main(String[] args) {
        Cliente marcos = new Cliente(111, "Marcos");
        clientRepository.add(marcos);
        List<Reserva> paqueteCompleto = new ArrayList<>();
        paqueteCompleto.add(new Reserva("Hotel Dos Reyes", TipoReserva.HOTEL, 100));
        paqueteCompleto.add(new Reserva("Plan de comida all inclusive", TipoReserva.COMIDA, 100));
        paqueteCompleto.add(new Reserva("Boleto de avión", TipoReserva.BOLETO_VIAJE, 100));
        paqueteCompleto.add(new Reserva("Combi al hotel", TipoReserva.TRANSPORTE, 100));
        Localizador localizadorPaqueteCompleto = new Localizador(marcos, paqueteCompleto);
        localizadorRepository.add(localizadorPaqueteCompleto);

        List<Reserva> otrasReservas = new ArrayList<>();
        otrasReservas.add(new Reserva("Sheraton", TipoReserva.HOTEL, 1000));
        otrasReservas.add(new Reserva("Amerian", TipoReserva.HOTEL, 500));
        otrasReservas.add(new Reserva("Boleto Ferry", TipoReserva.BOLETO_VIAJE, 10));
        otrasReservas.add(new Reserva("Boleto Tren", TipoReserva.BOLETO_VIAJE, 20));
        Localizador otroLocalizador = new Localizador(marcos, otrasReservas);
        localizadorRepository.add(otroLocalizador);

        List<Reserva> unaSolaReserva = new ArrayList<>();
        unaSolaReserva.add(new Reserva("Hotel Guaminí", TipoReserva.HOTEL, 1000));
        Localizador localizadorUnaReserva = new Localizador(marcos, unaSolaReserva);

        System.out.println(localizadorPaqueteCompleto.toString());
        System.out.println("----------------------------------------");
        System.out.println(otroLocalizador.toString());
        System.out.println("----------------------------------------");
        System.out.println(localizadorUnaReserva.toString());

        System.out.println("----------------------------------------METRICAS----------------------------------------");
        AnalizadorDeMetricas analizadorDeMetricas = new AnalizadorDeMetricas(localizadorRepository);
        System.out.println(
                "-Cantidad de localizadores vendidos: " + analizadorDeMetricas.getCantidadDeLocalizadoresVendidos());
        System.out.println("-Cantidad total de reservas: " + analizadorDeMetricas.getCantidadTotalDeReservas());
        System.out.println("-Cantidad total de reservas por tipo: ");
        analizadorDeMetricas.dictionaryCantidadDeReservasPorTipo()
                .forEach((k, v) -> System.out.println("\t\t-" + k + ": " + v));
        System.out.println("Total de ventas: " + analizadorDeMetricas.getTotalVentas());
        System.out.println("Promedio de ventas: " + analizadorDeMetricas.getPromedioVentas());
    }
}

package practica_agencia_turismo;

import practica_agencia_turismo.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== PROGRAMA AGENCIA TURISMO =========");

        while (true) {

            boolean indicadorFinalPrograma = false;

            System.out.println("1) CREAR CLIENTE");
            System.out.println("2) CREAR LOCALIZADOR");
            System.out.println("3) CONSULTAR CLIENTE");
            System.out.println("4) SALIR");

            Scanner teclado = new Scanner(System.in);

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    crearLocalizadores();
                    break;
                case 3:
                    consultarClientes();
                    break;
                case 4:
                    indicadorFinalPrograma = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            if (indicadorFinalPrograma) {
                break;
            }
        }

    }

    private static void crearCliente() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("====== CREACION CLIENTE ======");

        System.out.print("Ingresar nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingresar identificacion: ");
        String identificacion = teclado.nextLine();

        Cliente cliente = new Cliente();

        cliente.setIdentificacion(identificacion);
        cliente.setNombre(nombre);

        clientes.add(cliente);

        System.out.println("\n!!!CREACION EXITOSA!!!\n");
    }

    private static void consultarClientes() {
        clientes.forEach(System.out::println);
    }

    private static void crearLocalizadores() {
        System.out.println("====== CREACION LOCALIZADORES =======");
        System.out.println("Ingrese numero de identificacion cliente ");

        Scanner teclado = new Scanner(System.in);

        String numeroIdentificacion = teclado.nextLine();

        Cliente cliente = obtenerCliente(numeroIdentificacion);

        if (cliente == null) {
            return;
        }

        Localizador localizador = new Localizador();

        boolean finalizarSeleccion = false;

        while (true) {
            System.out.println("===== SELECCION RESERVA =====");
            System.out.println("1) Reserva hotel");
            System.out.println("2) Reserva comida");
            System.out.println("3) Reserva boletas de viaje");
            System.out.println("4) Reserva transporte");
            System.out.println("5) Finalizar seleccion");

            int tipoReserva = teclado.nextInt();

            switch (tipoReserva) {
                case 1:
                    localizador.getReservas().add(new ReservaHotel());
                    break;
                case 2:
                    localizador.getReservas().add(new ReservaComida());
                    break;
                case 3:
                    localizador.getReservas().add(new ReservaBoletosViaje());
                    break;
                case 4:
                    localizador.getReservas().add(new ReservaTransporte());
                    break;
                case 5:
                    finalizarSeleccion = true;
                    break;
            }

            if (finalizarSeleccion) {
                break;
            }
        }

        cliente.getLocalizadores().add(localizador);
    }

    private static Cliente obtenerCliente(String identificacion) {

        Cliente cliente = clientes.stream().filter(x -> x.getIdentificacion().equals(identificacion))
                .findAny().orElse(null);

        if (cliente == null) {
            System.out.println("No existe cliente");
        }
        return cliente;
    }
}

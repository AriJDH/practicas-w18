package practica_agencia_turismo;

import practica_agencia_turismo.clases.Cliente;

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

    }

}

package clase3.supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente("Juan", "Perez", 123456);
        Cliente cliente2 = new Cliente("Maria", "Gomez", 87654321);
        Cliente cliente3 = new Cliente("Pedro", "Rodriguez", 12345678);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);


        System.out.println("Clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.println("Clientes luego de eliminar uno: ");
        clientes.remove(cliente1);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.println("Ingresar el dni de un cliente para buscarlo: ");

        Scanner teclado = new Scanner(System.in);
        int dni = teclado.nextInt();
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clienteBuscado = cliente;
            }
        }
        teclado.close();
        if (clienteBuscado != null) {
            System.out.println("El cliente buscado es: " + clienteBuscado);
        } else {
            System.out.println("No se encontro el cliente");
        }



    }
}

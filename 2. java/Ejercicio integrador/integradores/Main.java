package integradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Cliente c1 = new Cliente(12365458L, "Roberto", "Hernandez");
        Cliente c2 = new Cliente(65987456L, "Juan", "Perez");
        Cliente c3 = new Cliente(11254789L, "Maria", "Villa");


        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        for (Cliente c : listaClientes) {
            System.out.println(c);
        }

        //borrado del cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a borrar");
        Long dniBorrado = teclado.nextLong();
        boolean flag = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("No se encontró el cliente");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }

        //buscar cliente en particular
        System.out.println("Ingrese el dni del cliente deseado");
        Long dniBuscado = teclado.nextLong();

        flag = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println(c);
            }
        }

        if (!flag) {
            System.out.println("No se encontró el cliente");
        }

    }
}

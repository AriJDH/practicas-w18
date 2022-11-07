import Entity.Cliente;
import Entity.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente daniel = new Cliente("12345", "daniel", "cagliari");
        Cliente alberto = new Cliente("125466", "alberto", "forquera");
        Cliente alice = new Cliente("125467", "alice", "smith");

        Scanner scanner = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(daniel);
        clientes.add(alberto);
        clientes.add(alice);

        List<Factura> facturas = new ArrayList<>();

        clientes.forEach(Cliente::imprimirDatos);
        System.out.println("--------------------------------\n");
        clientes.remove(alice);
        clientes.forEach(Cliente::imprimirDatos);

        System.out.println("--------------------------------\n");

        System.out.println("Por favor coloque el nro de DNI de la persona a buscar:");
        String nroDNI = scanner.nextLine();

        String c = "Cliente no encontrado";
        for (Cliente cliente : clientes){
            if (nroDNI.equals(cliente.getDNI())){
                c = cliente.toString();
                break;
            }
        }
        System.out.println(c);

        System.out.println("--------------------------------\n");



    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(25,"Juan","restrepo");
        Cliente cliente2 = new Cliente(30,"Andres","lopez");
        Cliente cliente3 = new Cliente(27,"ernesto","villa");

        ArrayList<Cliente> coleccionClientes = new ArrayList<>();
        coleccionClientes.add(cliente1);
        coleccionClientes.add(cliente2);
        coleccionClientes.add(cliente3);

        System.out.println("Mostrando clientes");
        for (Cliente cliente: coleccionClientes){
            System.out.println(cliente.toString());
        }

        System.out.println("Eliminando uno de los clientes");
        coleccionClientes.remove(1);

        System.out.println("Mostrando clientes restantes");
        for (Cliente cliente: coleccionClientes){
            System.out.println(cliente.toString());
        }
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Dni de un cliente");
        int dni_cliente = entrada.nextInt();

        boolean clienteEncontrado = false;
        for (Cliente cliente: coleccionClientes){
            if (cliente.getDni() == dni_cliente){
                System.out.println(cliente.toString());
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado){
            System.out.println("No se encontró un cliente con este DNI");
        }




    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int dniSolicitado = 0;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ejercicio supermercado");

        //Creación de clientes
        Cliente cliente1 = new Cliente(1, "Verónica", "Juarez");
        Cliente cliente2 = new Cliente(2, "Camila", "Pepe");
        Cliente cliente3 = new Cliente(3, "Mariano", "Lopez");

        //Lista de clientes
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        //Mostrar lista clientes
        System.out.println("Los clientes son: ");

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

        //Eliminación de un cliente
        listaClientes.remove(cliente2);

        //Mostrar lista clientes
        System.out.println("Los clientes son: ");

        for (Cliente cliente : listaClientes) {
            System.out.println("Los clientes son " + cliente);
        }

        System.out.println("Ingrese el dni del cliente que necesita buscar.");
        dniSolicitado = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<listaClientes.size(); i++){
            if(dniSolicitado == listaClientes.get(i).getDni()){
                System.out.println(listaClientes.get(i).toString());
            }
        }



    }
}

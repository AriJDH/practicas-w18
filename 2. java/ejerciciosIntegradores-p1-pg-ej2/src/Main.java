import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Supermercado “El económico”!");
        ArrayList<Cliente> clienteArrayList = new ArrayList<>();
        clienteArrayList.add(new Cliente(2918371, "babab", "abababa"));
        clienteArrayList.add(new Cliente(92834720, "uiiuiui", "iuiuiui"));
        clienteArrayList.add(new Cliente(1947829, "ogogogog", "gogogogo"));
        System.out.println("Lista de clientes inicial:");
        clienteArrayList.forEach(System.out::println);

        clienteArrayList.remove(1);
        System.out.println("Lista de clientes reducido:");
        clienteArrayList.forEach(System.out::println);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Busqueda - ingresar DNI:");
        int dni = myObj.nextInt();  // Read user input
        Optional<Cliente> clienteOptional = clienteArrayList.stream().filter(x -> x.getDni() == dni).findFirst();
        if (clienteOptional.isPresent()) {
            System.out.println(clienteOptional);
        } else {
            System.out.println("Cliente no encontrado :'(");
        }
    }
}
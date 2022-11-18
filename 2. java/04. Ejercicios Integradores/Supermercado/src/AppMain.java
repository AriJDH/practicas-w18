import supermercado.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("98743965", "Ana", "Thomas");
        Cliente c2 = new Cliente("39864567", "Mauro", "Lorenz");
        Cliente c3 = new Cliente("92837646", "Gabriela", "Zapata");
        List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(c1, c2, c3));
        System.out.println("-----------------------------------------------");
        System.out.println("---------Supermercado \'El Económico\'---------");
        System.out.println("-----------------------------------------------");
        System.out.println("CLIENTES:");
        listaClientes.forEach(c-> System.out.println(c));

        listaClientes.remove(c2);
        System.out.println("-----------------------------------------------");
        System.out.println("CLIENTES:");
        listaClientes.forEach(c-> System.out.println(c));

        //buscar por DNI

    }
}

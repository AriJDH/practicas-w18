package SuperEjemploPlayground;
import Supermercado.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creamos 3 clientes
        Cliente cliente1 = new Cliente(4564534L, "Cosme", "Fulanito");
        Cliente cliente2 = new Cliente(23324454L, "Max", "Power");
        Cliente cliente3 = new Cliente(34232321L, "Lisa", "Simpson");

        //Los agregamos a la lista
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for(Cliente cliente: listaClientes){
            System.out.println(cliente.toString());
        }
    }
}

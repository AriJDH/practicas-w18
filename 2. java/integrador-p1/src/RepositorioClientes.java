import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private List<Cliente> clientes;

    public RepositorioClientes(List<Cliente> clientes) {
        this.clientes = new ArrayList<>();
    }

    public void agregaCliente(Cliente cliente){
        if (!clientes.contains(cliente)){
            clientes.add(cliente);
            System.out.println("Cliente Agregado");
        }else{
            System.out.println("Cliente ya existe");
        }
    }

    public void showClientes(){
        for (Cliente cliente: clientes
             ) {
            System.out.println(cliente);
        }
    }
}

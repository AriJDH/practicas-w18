package supermercado;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Supermercado {
    private String nombre;
    private List<Cliente> clientes;

    public Supermercado(String nombre, List<Cliente> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public String getNombre() { return nombre; }

    public List<Cliente> getClientes() { return clientes; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }

    public void mostrarClientes(){
        System.out.println("**Supermercado**: "+nombre);
        clientes.stream().map(cliente -> cliente.toString()).forEach(System.out::println);
    }

    public void eliminarRegistroCliente(){
        clientes.remove(0);
    }

    public void consultarDatosCliente(String dni){
        Optional<Cliente> temp= clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();
        temp.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Cliente no encontrado"));
    }

}

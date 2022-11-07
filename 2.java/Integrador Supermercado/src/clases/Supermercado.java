package clases;

import java.util.ArrayList;
import java.util.Optional;

public class Supermercado {

    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public Supermercado() {
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void crearCliente(String dni, String nombre, String apellido){
        this.clientes.add(new Cliente(dni, nombre, apellido));
    }

    private Cliente buscarCliente(Cliente cliente){
        int i = 0;
        Cliente clienteBuscado = null;
        while(i < this.clientes.size() && clienteBuscado == null){
            if(cliente.getDni().equals(this.clientes.get(i).getDni())){
                clienteBuscado = cliente;
            }
            i++;
        }
        return clienteBuscado;

    }
    public void crearFactura(Cliente cliente){
        if(buscarCliente(cliente) == null){
            this.facturas.add(new Factura(new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido())));
        }else{
            this.facturas.add(new Factura(cliente));
        }

    }

    public void mostrarDatosClientes(){
        for (Cliente cliente: this.clientes
             ) {
            System.out.println(cliente.toString());
        }
    }

    public void eliminarCliente(String dni){
        this.clientes.removeIf(c -> (c.getDni().equals(dni)));
    }

    public void buscarCliente(String dni){
        Optional<Cliente> clienteBuscado = this.clientes.stream().filter(name-> name.getDni().equals(dni)).findFirst();
        if(clienteBuscado.isEmpty() == false){
            System.out.println(clienteBuscado.toString());
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }

}

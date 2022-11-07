package repositorios;

import clases.Cliente;
import interfaces.Crud;

import java.util.LinkedList;

public class RepositorioCliente implements Crud<Cliente, String> {

    private LinkedList<Cliente> clientes;

    public RepositorioCliente(){
        this.clientes = new LinkedList<Cliente>();
    }

    @Override
    public String alta(Cliente obj) {
        String res = "ERROR!";
        try{
            Cliente consultaClienteConMismoDni = this.conuslta(obj.getDni());
            if(consultaClienteConMismoDni == null){
                clientes.add(obj);
                res = "Cliente registrado con éxito.";
            }else{
                res = "Ya existe un cliente registrado con el mismo DNI: \n"+ consultaClienteConMismoDni;
            }
        }catch(Exception ex){
            res = "Ha ocurido un error: " +ex.getMessage();
        }finally{
            return res;
        }
    }

    @Override
    public String baja(String id) {
        return clientes.remove(new Cliente(id))?"Cliente con DNI: "+id+" eliminado exitosamente.":"No se encontró un cliente con DNI: "+id+".";
    }

    @Override
    public String modificacion(Cliente obj) {
        return null;
    }

    @Override
    public Cliente conuslta(String id) {
        return clientes.stream().filter(c -> c.getDni().equals(id)).findFirst().orElse(null);
    }

    public void preCargaClientes(){
        Cliente c1 = new Cliente("1111111", "Nicolas", "Sanchez");
        Cliente c2 = new Cliente("2222222", "Maria", "Gonzalez");
        Cliente c3 = new Cliente("3333333", "Juan", "Perez");

        alta(c1);
        alta(c2);
        alta(c3);
    }

    public void verTodoslosClientes(){
        System.out.println("***** LISTADO DE CLIENTES *****");
        clientes.stream().forEach(System.out::println);
    }
}

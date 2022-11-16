package Repository;

import Models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente>{

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);

    }

    @Override
    public void mostrarPantalla() {
        for (Cliente cliente:listaClientes  ) {
            System.out.println("Dni: "+cliente.getDni());
            System.out.println("Nombre: "+cliente.getNombre());
            System.out.println("Apellido: "+cliente.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {

        boolean bandera = false;
        for (Cliente cliente: listaClientes){
            if(cliente.getDni().equals(dniBuscado)){
                System.out.println("------ Cliente encontrado, sus datos son: -----");
                System.out.println("Dni: "+cliente.getDni());
                System.out.println("Nombre: "+cliente.getNombre());
                System.out.println("Apellido: "+cliente.getApellido());
                return Optional.of(cliente);
            }
        }
        if (!bandera){
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        boolean bandera =false;
        Optional<Cliente> cli = this.buscar(dniBorrado);
        if (cli.isEmpty()){
            System.out.println("No se encontró el cliente a borrar");
        }else{
            System.out.println("cliente borrado correctamente");
            listaClientes.remove(cli.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}

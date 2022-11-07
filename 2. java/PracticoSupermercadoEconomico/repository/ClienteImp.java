package SupermercadoEconomico.repository;

import SupermercadoEconomico.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements ICrud<Cliente>{
    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Cliente cliente : listaClientes){
            System.out.println("DNI: "+cliente.getDni());
            System.out.println("Nombre: "+cliente.getNombre());
            System.out.println("Apellido: "+cliente.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(String dniBuscar) {
       boolean flag = false;
        for(Cliente clientes : listaClientes){
            if(dniBuscar.equals(clientes.getDni())){
                System.out.println("----------Cliente encontrado: ----------");
                System.out.println("DNI: "+ clientes.getDni());
                System.out.println("Nombre: "+ clientes.getNombre());
                System.out.println("Apellido: "+clientes.getApellido());
                return Optional.of(clientes);
            }
        }

        if(!flag){
            System.out.println("No se pudo encontrar al cliente!");
        }
        return Optional.empty();

    }

    @Override
    public void eliminar(String dniBorrado) {
        Optional<Cliente> cliente = this.buscar(dniBorrado);

        if(cliente.isEmpty()){
            System.out.println("No se encontro el cliente a borrar");
        }else{
            System.out.println("Cliente borrado correctamente!");
            listaClientes.remove(cliente.get());
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}

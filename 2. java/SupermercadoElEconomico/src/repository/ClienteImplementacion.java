package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImplementacion implements CRUDRepository <Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();
    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes) {
            System.out.println("Dni " + c.getDni());
            System.out.println("Nombre " + c.getNombre());
            System.out.println("Apellido " + c.getApellido());
        }

    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean bandera = false;
        System.out.println("Ingrese dni a buscar");
        Long dniBuscado = teclado.nextLong();
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)){
                System.out.println("Cliente encontrado : ");
                System.out.println("Dni " + c.getDni());
                System.out.println("Nombre " + c.getNombre());
                System.out.println("Apellido " + c.getApellido());
                return Optional.of(c);
            }

        }
        if (bandera == false) {
            System.out.println("Cliente no encontrado");
        }


        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<Cliente> cli = this.buscar(dniBorrado);
        if (cli.isEmpty()) {
            System.out.println("No se encontro cliente a borrar");
        }else {
            System.out.println("Cliente borrado correctamente");
            listaClientes.remove(cli.get());
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}

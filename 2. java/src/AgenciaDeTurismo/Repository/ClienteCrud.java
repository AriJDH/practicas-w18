package AgenciaDeTurismo.Repository;

import AgenciaDeTurismo.Clases.Cliente;
import AgenciaDeTurismo.Interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteCrud implements CrudRepository<Cliente> {

    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (AgenciaDeTurismo.Clases.Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean bandera = false;
        for (AgenciaDeTurismo.Clases.Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado.toString())) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                return Optional.of(c);
            }
        }

        if (!bandera) {
            System.out.println("Cliente no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<AgenciaDeTurismo.Clases.Cliente> cli = this.buscar(dniBorrado);

        if (cli.isEmpty()) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
            listaClientes.remove(cli.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}

package Repository;


import Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClienteImp implements CRUDRepository <Cliente> {

    List<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        System.out.println("Los datos personales de los clientes son: " + "\n");
        for(int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i));
        }
    }

    boolean encontrado = false;
    @Override
    public Optional<Cliente> buscar(String dniBuscado) {

        encontrado = false;
        for(int i=0; i<clientes.size(); i++) {
            if(clientes.get(i).getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado, sus datos son: ");
                System.out.println(clientes.get(i));
                encontrado = true;
                return Optional.of(clientes.get(i));
            }
        }

        if(!encontrado) {
            System.out.println("ERROR! El número del dni no coincide con ninguno de los clientes registrados.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String dniBorrado) {
       Optional<Cliente> cli = this.buscar(dniBorrado);

        if(cli.isEmpty()) {
            System.out.println("No se encontro el cliente a borrar");
        } else {
            clientes.remove(cli.get());
            System.out.println("El cliente se elimino correctamente.");
            System.out.println("Los datos de los clientes restantes son: ");
            for(int i = 0; i<clientes.size(); i++){
                this.mostrarPantalla();
            }
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return null;
    }
}

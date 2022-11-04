package sistema;

import repositorios.RepositorioCliente;

public class SistemaSupermercado {
    private RepositorioCliente repoClientes;

    public SistemaSupermercado() {
        this.repoClientes = new RepositorioCliente();
    }

    public void ejecutarParte1(){
        this.repoClientes.preCargaClientes();
        this.repoClientes.verTodoslosClientes();

        System.out.println("***** SE DA DE BAJA EL CLIENTE CON DNI 2222222 *****");
        this.repoClientes.baja("2222222");
        this.repoClientes.verTodoslosClientes();
    }
}

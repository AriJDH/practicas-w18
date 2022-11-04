package clase4_b_EjerciciosIntegrador.repositorio;

import clase4_b_EjerciciosIntegrador.modelo.Cliente;

public interface IClienteRepository extends IRepository<Cliente> {

    void add(Cliente cliente);
}

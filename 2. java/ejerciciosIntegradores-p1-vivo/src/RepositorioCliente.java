import java.util.List;

public class RepositorioCliente implements Repositorio<Cliente>{

    List<Cliente> clienteList;

    @Override
    public List<Cliente> buscarTodo() {
        return clienteList;
    }

    @Override
    public void aplicarDescuento() {

    }

    @Override
    public void agregar(Cliente o) {
        clienteList.add(o);
    }
}

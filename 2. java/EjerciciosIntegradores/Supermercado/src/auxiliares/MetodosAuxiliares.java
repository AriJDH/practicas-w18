package auxiliares;

import clases.*;

import java.util.Optional;

public class MetodosAuxiliares {

    private RepositorioProductos repositorioProductos = new RepositorioProductos();
    private RepositorioClientes repositorioClientes = new RepositorioClientes();
    private RepositorioFacturas repositorioFacturas = new RepositorioFacturas();

    public MetodosAuxiliares() {
    }

    public void guardarClientesEnRepositorio() {
        String nombres[] = {"Pamela", "Yanina", "Miguel"};
        String apellidos[] = {"Pereira", "Piredda", "Avalle"};
        Long dni[] = {13456789L, 56789123L, 26987567L};

        for (int i = 0; i < 3; i++) {
            Cliente cliente = new Cliente(dni[i], nombres[i], apellidos[i]);
            repositorioClientes.guardarCliente(cliente);
        }

        return;
    }

    public void mostrarClientes() {
        repositorioClientes.getClientes()
                .stream()
                .forEach(cliente -> System.out.println("-----------------" +
                        '\n' + cliente.getDni() + " " +
                        '\n' + cliente.getNombre() +
                        '\n' + cliente.getApellido()));

        return;
    }

    public void mostrarClientePorDni(Optional<Cliente> cliente) {
        if (cliente.isPresent()) {
            cliente.stream()
                    .forEach(cli -> System.out.println("-----------------" +
                            '\n' + cli.getDni() + " " +
                            '\n' + cli.getNombre() +
                            '\n' + cli.getApellido()));
        } else {
            System.out.println("Cliente no encontrado");
        }

        return;
    }

    public Optional<Cliente> obtenerClientePorDni(Long dni) {
        Optional<Cliente> filterCliente = repositorioClientes.getClientes().stream()
                .filter(clientes -> clientes.getDni() == dni)
                .findFirst();

        if (filterCliente.isPresent()) {
            return filterCliente;
        } else {
            return null;
        }
    }

    public Optional<Producto> obtenerProductoPorId(String id) {
        Optional<Producto> filterProducto = repositorioProductos.getProductos().stream()
                .filter(productos -> productos.getId() == id)
                .findFirst();

        if (filterProducto.isPresent()) {
            return filterProducto;
        } else {
            return null;
        }
    }

    public void crearFactura(int numeroFactura, Cliente cliente, ItemsPorFactura item) {

        Optional<Factura> filterFactura = repositorioFacturas.getFacturas().stream()
                .filter(facturas -> facturas.getNumeroFactura() == numeroFactura)
                .findFirst();

        if (filterFactura.isEmpty()) {
            Factura factura = new Factura(numeroFactura, cliente, item);
            repositorioFacturas.guardarFacturas(factura);
        }
    }

    public void crearProducto(String id, String producto, double costoUnitario) {

        Optional<Producto> filterProducto = repositorioProductos.getProductos().stream()
                .filter(productos -> productos.getId() == id)
                .findFirst();

        if (filterProducto.isEmpty()) {
            Producto prod = new Producto(id, producto, costoUnitario, repositorioProductos);
            repositorioProductos.cargarProductos(prod);
        }
    }

    public void crearCliente(Long dni, String nombre, String apellido) {

        Optional<Cliente> filterCliente = repositorioClientes.getClientes().stream()
                .filter(clientes -> clientes.getDni() == dni)
                .findFirst();

        if (filterCliente.isEmpty()) {
            Cliente cliente = new Cliente(dni, nombre, apellido);
            repositorioClientes.guardarCliente(cliente);
        }
    }
}

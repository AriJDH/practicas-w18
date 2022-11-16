import auxiliares.MetodosAuxiliares;
import clases.*;

import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MetodosAuxiliares auxiliares = new MetodosAuxiliares();
        auxiliares.guardarClientesEnRepositorio();
        auxiliares.mostrarClientes();

        auxiliares.crearCliente(26986567L, "nombre", "apellido");
        auxiliares.mostrarClientes();

        auxiliares.crearProducto("1", "leche", 100.00);
        auxiliares.crearProducto("2", "yerba", 150.30);

        Optional<Producto> producto = auxiliares.obtenerProductoPorId("2");
        Optional<Cliente> cliente = auxiliares.obtenerClientePorDni(26986567L);

    }

}
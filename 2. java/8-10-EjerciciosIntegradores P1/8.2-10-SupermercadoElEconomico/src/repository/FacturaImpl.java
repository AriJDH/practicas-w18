package repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaImpl implements CRUDRepository<Factura> {

    // Base de facturas
    List<Factura> facturas = new ArrayList<>();

    // Traemos al ClienteImpl para poder usar sus métodos
    ClienteImpl clienteImpl = new ClienteImpl();

    // Implementación de métodos
    @Override
    public void guardar(Factura factura) {
        if (clienteImpl.buscarPorId(factura.getCliente().getDni()) == null) {
            clienteImpl.guardar(factura.getCliente());
        }
        facturas.add(factura);
        System.out.println("La factura fue agregada");
    }

    @Override
    public void mostrarTodos() {
        System.out.println("--------- Listado de Facturas ---------");
        facturas.forEach(System.out::println);
    }

    @Override
    public Factura buscarPorId(Long codigo) {
        Factura facturaEncontrada = null;
        for (Factura factura : facturas) {
            if (factura.getCoodigo().compareTo(codigo) == 0) {
                facturaEncontrada = factura;
                System.out.println("La factura encontrada es " + factura);
            }
        }
        if (facturaEncontrada == null) {
            System.out.println("No se pudo encontrar la factura");
        }
        return facturaEncontrada;
    }

    @Override
    public void eliminarPorId(Long id) {
        Factura facturaEncontrada = buscarPorId(id);
        facturas.remove(facturaEncontrada);
        System.out.println("La factura fue eliminada");
    }

    @Override
    public List<Factura> listarTodos() {
        return facturas;
    }
}

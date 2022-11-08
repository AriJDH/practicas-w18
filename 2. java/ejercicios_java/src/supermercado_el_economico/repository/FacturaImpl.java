package supermercado_el_economico.repository;

import supermercado_el_economico.clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImpl implements CRUDRepository<Factura> {

    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void save(Factura objeto) {
        objeto.calcularTotalFactura();
        this.facturas.add(objeto);
    }

    @Override
    public void mostrarTodo() {

        System.out.println("===== Facturas consultadas =======");
        for (Factura factura : facturas) {
            System.out.println(factura.toString());
        }

    }

    @Override
    public Optional<Factura> buscar(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }
}

package supermercado_el_economico.repository;

import supermercado_el_economico.clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImpl implements CRUDRepository<Factura> {

    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void save(Factura objeto) {
        this.facturas.add(objeto);
    }

    @Override
    public void mostrarTodo() {

    }

    @Override
    public Optional<Factura> buscar(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }
}

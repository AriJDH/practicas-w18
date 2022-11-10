package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {

    List<Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void create(Factura object) {
        listaFacturas.add(object);
    }

    @Override
    public void mostrarPorPantalla() {
        listaFacturas.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Factura> getById(String id) {
        return listaFacturas.stream().filter(f -> id.equals(f.getCodigo())).findAny();
    }

    @Override
    public void delete(String id) {
        Optional<Factura> fact = this.getById(id);

        if(fact.isEmpty()) {
            System.out.println("No se encontró la factura a borrar");
        } else {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(fact.get());
        }
    }

    @Override
    public List<Factura> getAll() {
        return listaFacturas;
    }
}

package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements CrudRepository <Factura> {

    List<Factura> facturaList = new ArrayList<>();

    @Override
    public void create(Factura factura) {
        facturaList.add(factura);
    }

    @Override
    public Optional<Factura> retrieve(int codigo) {
        return facturaList.stream().filter(x -> x.getCodigo() == codigo).findFirst();
    }

    @Override
    public List<Factura> retrieveAll() {
        return facturaList;
    }

    @Override
    public void printAll() {
        facturaList.forEach(System.out::println);
    }

    @Override
    public Boolean update(int codigo, Factura factura) {
        return retrieve(codigo).filter(value -> Collections.replaceAll(facturaList, value, factura)).isPresent();
    }

    @Override
    public void delete(int codigo) {
        retrieve(codigo).ifPresent(factura -> facturaList.remove(factura));
    }
}

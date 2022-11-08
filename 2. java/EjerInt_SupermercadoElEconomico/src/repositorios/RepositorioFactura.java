package repositorios;

import clases.Factura;
import interfaces.Crud;

import java.util.LinkedList;

public class RepositorioFactura implements Crud<Factura, Integer> {

    private LinkedList<Factura> repoFacturas;

    public RepositorioFactura(){this.repoFacturas = new LinkedList<Factura>();}

    @Override
    public String alta(Factura obj) {
        repoFacturas.add(obj);
        return obj.toString();
    }

    @Override
    public String baja(Integer id) {
        return null;
    }

    @Override
    public String modificacion(Factura obj) {
        return null;
    }

    @Override
    public Factura conuslta(Integer id) {
        return null;
    }
}

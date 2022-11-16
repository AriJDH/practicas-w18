package clases;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFacturas {

    private List<Factura> facturas = new ArrayList<>();

    public RepositorioFacturas() {
    }

    public void guardarFacturas(Factura factura) {
        facturas.add(factura);
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}

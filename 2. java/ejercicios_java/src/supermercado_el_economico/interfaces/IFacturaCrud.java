package supermercado_el_economico.interfaces;

import supermercado_el_economico.clases.Cliente;
import supermercado_el_economico.clases.Factura;
import supermercado_el_economico.clases.Item;

import java.util.List;

public interface IFacturaCrud {

    void crearFactura(Cliente cliente, List<Item> items);

    void consultarFactura();

    void eliminarFactura();

    void modificarFactura();

    void calcularTotalFactura();
}

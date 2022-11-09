package SuperMercadoEconomico.Repository;

import SuperMercadoEconomico.Clases.Cliente;
import SuperMercadoEconomico.Clases.Factura;
import SuperMercadoEconomico.Interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaCrud implements CrudRepository<Factura> {
    List<Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {

        for (Factura fact : listaFacturas) {
            System.out.println(fact.getCliente().toString());
            System.out.println(fact.getItem().toString());
            System.out.println("Total compra: "+fact.getTotalCompra());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {

        boolean bandera = false;
        for (Factura f : listaFacturas) {
            if (f.getCodigo().equals(codigoBuscado)) {
                System.out.println("----Factura encontrada, sus datos son: ----");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (bandera == false) {
            System.out.println("Factura no encontrada");
        }

        return Optional.empty();

    }

    @Override
    public void eliminar(Long codigoBorrado) {

        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isEmpty()) {
            System.out.println("No se encontró la factura a borrar");
        }
        else {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(fact.get());
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}

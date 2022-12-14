package Repository;

import Model.Cliente;
import Model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository <Factura>{

    List <Factura> facturas = new ArrayList<Factura>();
    @Override
    public void save(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        System.out.println("Los datos de las facturas son los siguientes: ");
        for(int i=0; i<facturas.size(); i++){
            System.out.println(facturas.get(i));
        }
    }

    boolean encontrado = false;
    @Override
    public Optional<Factura> buscar(String codigoBuscado) {

        encontrado = false;
        for(int i=0; i<facturas.size(); i++) {
            if(facturas.get(i).getCodigo().equals(codigoBuscado)) {
                System.out.println("Cliente encontrado, sus datos son: ");
                System.out.println(facturas.get(i));
                encontrado = true;
                return Optional.of(facturas.get(i));
            }
        }

        if(!encontrado) {
            System.out.println("ERROR! El codigo no coincide con ninguna de las facturas registrados.");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(String codigoBorrado) {
        Optional<Factura> fact = this.buscar(codigoBorrado);

        if(fact.isEmpty()) {
            System.out.println("No se encontro el cliente a borrar");
        } else {
            facturas.remove(fact.get());
            System.out.println("La factura se elimino correctamente.");
            System.out.println("Los datos de las facturas restantes son: ");
            for(int i = 0; i<facturas.size(); i++){
                this.mostrarPantalla();
            }
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}

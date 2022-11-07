package Repositorio;

import Clases.Cliente;
import Clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUD <Factura> {
    List<Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void guardar(Factura factura) {
        listaFacturas.add(factura);
    }

    @Override
    public void imprimir() {
        for(Factura factura: listaFacturas) {
            System.out.println(factura.toString());
        }

    }

    @Override
    public Optional<Factura> buscar(int codigoBuscado) {

        boolean bandera = false;
        for (Factura f : listaFacturas) {
            if (f.getCodigo()==codigoBuscado) {
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
    public void eliminar(int codigoBorrado) {

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
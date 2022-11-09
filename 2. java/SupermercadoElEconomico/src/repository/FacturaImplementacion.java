package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImplementacion implements CRUDRepository<Factura>{

    List<Factura> listaFacturas = new ArrayList<Factura>();
    private Long codigoBorrado;

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura factura :listaFacturas){
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {
        boolean bandera =false;
        for (Factura f :listaFacturas){
            if (f.getCodigo().equals(codigoBuscado)){
                System.out.println("Facura encontrada los daton son: ");
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
    public void eliminar(Long id) {
        Optional<Factura> factura = this.buscar(codigoBorrado);
        if (factura.isEmpty()){
            System.out.println("No se encontro factura a borrar");
        }
        else {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(factura.get());
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}

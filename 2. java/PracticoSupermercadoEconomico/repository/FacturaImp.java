package SupermercadoEconomico.repository;

import SupermercadoEconomico.modelo.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICrud<Factura>{

    List <Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura factura : listaFacturas){
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        boolean flag = false;
        for (Factura factura : listaFacturas){
            System.out.println("-----Factura encontrada, sus datos son: -----");
            System.out.println(factura.toString());
            return Optional.of(factura);
        }

        if(!flag){
            System.out.println("Factura no encontrada!");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Factura> factura = this.buscar(id);

        if(factura.isEmpty()){
            System.out.println("No se encontro la factura a borrar!");
        }else{
            System.out.println("Factura borrada correctamente!");
            listaFacturas.remove(factura.get());
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}

package Repository;

import Model.Factura;
import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository <Item>{

    List <Item> items = new ArrayList<Item>();

    @Override
    public void save(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        System.out.println("Los datos de los items son los siguientes: ");
        for(int i=0; i<items.size(); i++){
            System.out.println(items.get(i));
        }
    }

    boolean encontrado = false;
    @Override
    public Optional<Item> buscar(String codigoBuscado) {

        encontrado = false;
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).getCodigo().equals(codigoBuscado)) {
                System.out.println("Cliente encontrado, sus datos son: ");
                System.out.println(items.get(i));
                encontrado = true;
                return Optional.of(items.get(i));
            }
        }

        if(!encontrado) {
            System.out.println("ERROR! El codigo no coincide con ninguno de los items registrados.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String codigoBorrado) {
        Optional<Item> It = this.buscar(codigoBorrado);

        if(It.isEmpty()) {
            System.out.println("No se encontro el cliente a borrar");
        } else {
            items.remove(It.get());
            System.out.println("La factura se elimino correctamente.");
            System.out.println("Los datos de las facturas restantes son: ");
            for(int i = 0; i<items.size(); i++){
                this.mostrarPantalla();
            }
        }
    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }
}

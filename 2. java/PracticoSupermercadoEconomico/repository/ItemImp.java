package SupermercadoEconomico.repository;

import SupermercadoEconomico.modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICrud<Item>{
    List<Item> listaItems = new ArrayList<Item>();

    @Override
    public void save(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item item : listaItems){
            System.out.println(item.toString());
        }
    }

    @Override
    public Optional<Item> buscar(String id) {
        boolean flag = false;
        for (Item item : listaItems){
            if(item.getCodigo().equals(id)){
                System.out.println("-----Item encontrado, sus tedos son: ------");
                System.out.println(item.toString());
                return Optional.of(item);
            }
        }

        if(!flag){
            System.out.println("Item no encontrado!");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(String id) {
        Optional<Item> item = this.buscar(id);

        if(item.isEmpty()){
            System.out.println("No se encontro el item a borrar!");
        }else {
            System.out.println("Item borrado correctamente!");
            listaItems.remove(item.get());
        }
    }

    @Override
    public List<Item> traerTodos() {
        return listaItems;
    }
}

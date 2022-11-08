package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemImpl implements CRUDRepository<Item>{

    // Nuestra base de Items
    List<Item> items = new ArrayList<>();

    // Implementación de métodos
    @Override
    public void guardar(Item item) {
        items.add(item);
        System.out.println("El item fue agregado");
    }

    @Override
    public void mostrarTodos() {
        System.out.println("--------- Listado de Items ---------");
        items.forEach(System.out::println);
    }

    @Override
    public Item buscarPorId(Long codigo) {
        Item itemEncontrado = null;
        for (Item item : items) {
            if (item.getCodigo().compareTo(codigo) == 0) {
                itemEncontrado = item;
                System.out.println("El item encontrado es " + item);
            }
        } if(itemEncontrado == null){
            System.out.println("No se pudo encontrar el item");
        }
        return itemEncontrado;
    }

    @Override
    public void eliminarPorId(Long codigo) {
        Item itemEncontrado = buscarPorId(codigo);
        items.remove(itemEncontrado);
        System.out.println("El item fue eliminado");
    }

    @Override
    public List<Item> listarTodos() {
        return items;
    }
}

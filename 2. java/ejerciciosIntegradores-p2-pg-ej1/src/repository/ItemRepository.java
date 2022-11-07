package repository;

import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ItemRepository implements CrudRepository<Item>{

    List<Item> itemList = new ArrayList<>();

    @Override
    public void create(Item item) {
        itemList.add(item);
    }

    @Override
    public Optional<Item> retrieve(int codigo) {
        return itemList.stream().filter(x -> x.getCodigo() == codigo).findFirst();
    }

    @Override
    public List<Item> retrieveAll() {
        return itemList;
    }

    @Override
    public void printAll() {
        itemList.forEach(System.out::println);
    }

    @Override
    public Boolean update(int codigo, Item item) {
        return retrieve(codigo).filter(value -> Collections.replaceAll(itemList, value, item)).isPresent();
    }

    @Override
    public void delete(int codigo) {
        retrieve(codigo).ifPresent(factura -> itemList.remove(factura));
    }
}

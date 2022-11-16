package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository;

import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item, Integer> {

    private List<Item> items;

    public ItemImp() {
        this.items = new ArrayList<>();
    }

    @Override
    public void agregar(Item item){
        this.items.add(item);
    }

    @Override
    public void mostrar() {
        //Sin implementar
    }

    @Override
    public void eliminar(Integer valor) {
        //Sin implementar
    }

    @Override
    public Optional<Item> buscar(Integer valor) {
        //Sin implementar
        return Optional.empty();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

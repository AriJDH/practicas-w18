package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository;

import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class FacturaImp {

    public Double calcularValorTotal(List<Item> items){
        return  items.stream().map(i -> i.getCantidadComprada()*i.getCostoUnitario())
                .collect(Collectors.toList())
                .stream().reduce(0D, (a, b) -> a + b);
    }
}

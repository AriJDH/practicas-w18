package com.example.demo.Repository;

import com.example.demo.Interfaces.CrudRepository;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Sintoma;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SintomaRepository implements CrudRepository<Sintoma> {
    List<Sintoma> sintomalist = new ArrayList<>();

    @Override
    public List<Sintoma> getData() {
        Sintoma sintoma1 = new Sintoma("A","Vomito","Bajo");
        Sintoma sintoma2 = new Sintoma("B","Dificulta para respirar","Alto");
        Sintoma sintoma3 = new Sintoma("C","Dolor Cuerpo","Medio");
        Sintoma sintoma4 = new Sintoma("D","Fiebre mayo 37","Alto");
        Sintoma sintoma5 = new Sintoma("E","Dolor de cabeza","Bajo");

        sintomalist.add(sintoma1);
        sintomalist.add(sintoma2);
        sintomalist.add(sintoma3);
        sintomalist.add(sintoma4);
        sintomalist.add(sintoma5);

        return sintomalist;
    }

    @Override
    public Sintoma getData(String objeto) {
        this.getData();
        Sintoma sintomaResult = new Sintoma();
        if (sintomalist.stream().filter(x-> x.getNombre().equals(objeto)).count() > 0);
        {
            sintomaResult = sintomalist.stream().filter(x-> x.getNombre().equals(objeto)).findAny().get();
        }
        return sintomaResult;
    }
}

package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculadoraRepositoryImpl implements ICalculadoraRepository{

    private final List<Ingrediente> ingredientes;
    private final List<Plato> platos;

    public CalculadoraRepositoryImpl() {
        this.ingredientes = cargarI();
        this.platos = cargarP();
    }


    @Override
    public List<Ingrediente> findAllIngredientes() {
        return ingredientes;
    }

    @Override
    public List<Plato> findAllPlatos() {
        return platos;
    }

    private List<Ingrediente> cargarI(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(archivo, typeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ingredientes;


    }

    public List<Plato> cargarP(){


        List<Ingrediente> l1 = new ArrayList<>();
        l1.add(ingredientes.get(0));
        l1.add(ingredientes.get(1));

        List<Ingrediente> l2 = new ArrayList<>();
        l2.add(ingredientes.get(4));
        l2.add(ingredientes.get(5));

        List<Ingrediente> l3 = new ArrayList<>();
        l3.add(ingredientes.get(2));
        l3.add(ingredientes.get(3));

        Plato p1 = new Plato("Ensalada", l1);
        Plato p2 = new Plato("Sushi",  l2);
        Plato p3 = new Plato("Milanesa", l3);

        List<Plato> platos = new ArrayList<>();
        platos.add(p1);
        platos.add(p2);
        platos.add(p3);

        return platos;



    }

}

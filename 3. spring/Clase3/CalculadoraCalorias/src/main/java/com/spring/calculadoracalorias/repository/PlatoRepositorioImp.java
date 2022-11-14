package com.spring.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class PlatoRepositorioImp implements IPlatoRepositorio{

    private List<Plato> platos;
    private Map<String, Ingrediente> ingredientes;

    public PlatoRepositorioImp(){
        this.platos = new ArrayList<>();
        this.ingredientes = new HashMap<>();
        cargarIngredientes(cargarLista());
        cargarPlatos();
    }

    private void cargarPlatos(){
        Plato plato1 = new Plato("Plato1", Arrays.asList(ingredientes.get("Tomates"), ingredientes.get("Rúcula")));
        Plato plato2 = new Plato("Plato2", Arrays.asList(ingredientes.get("Coco"), ingredientes.get("Fresas")));
        this.platos.add(plato1);
        this.platos.add(plato2);

    }

    private List<Ingrediente> cargarLista(){
        ObjectMapper mapper = new ObjectMapper();
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        File jsonFile;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            listaIngredientes = mapper.readValue(jsonFile, new TypeReference<>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
        return  listaIngredientes;
    }

    private void cargarIngredientes(List<Ingrediente> lista){
        ingredientes = lista.stream()
                .collect(Collectors.toMap(Ingrediente::getName, Function.identity()));
    }

    @Override
    public Plato obtenerPlato(String nombre) {
        return platos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().get();
    }
}

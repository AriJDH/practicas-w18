package com.spring.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calorias.entity.Ingrediente;
import com.spring.calorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FoodRepository implements IFoodRepository {
    List<Ingrediente> ingredientes = new ArrayList<>();
    List<Plato> platos = new ArrayList<>();

    public FoodRepository() {
        loadList();
        loadPlatos();
    }

    @Override
    public List<Ingrediente> getComidas() {
        return ingredientes;
    }

    @Override
    public List<Ingrediente> findComidas(String name) {
        return ingredientes.stream()
                .filter(i -> i.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public Plato getPlato(String nombre, int peso) {
        Plato res = getPlatoByName(nombre);
        return res;
    }

    @Override
    public List<Plato> getPlatos(List<String> nombres) {
        List<Plato> platos = nombres.stream()
                .map(n -> getPlatoByName(n))
                .collect(Collectors.toList());

        boolean platosOk = !platos.stream()
                .anyMatch(p -> p == null);

        return platosOk ? platos : null;
    }

    // Devuelve null en caso de no existir el plato
    private Plato getPlatoByName(String nombre) {
        Optional<Plato> optionalPlato = platos.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst();

        return optionalPlato.isPresent() ? optionalPlato.get() : null;
    }

    private void loadPlatos() {
        Ingrediente lechuga = getIngrediente("Lechuga");
        Ingrediente tomate = getIngrediente("Tomates");
        List<Ingrediente> ingredientesEnsalada = Stream.of(lechuga, tomate).collect(Collectors.toList());

        Ingrediente pastaAlHuevo = getIngrediente("Pasta al huevo");
        Ingrediente salsa = getIngrediente("Salsa de tomate en conserva");
        Ingrediente cebolla = getIngrediente("Cebolla");
        Ingrediente vino = getIngrediente("Vino de mesa");
        Ingrediente leche = getIngrediente("Leche entera");
        Ingrediente cerdo = getIngrediente("Cerdo, lomo");
        List<Ingrediente> ingredientesRagu = Stream.of(pastaAlHuevo, salsa, cebolla, cerdo, leche, vino)
                .collect(Collectors.toList());

        Plato ensalada = new Plato("ensalada", ingredientesEnsalada);
        Plato ragu = new Plato("pasta al ragu", ingredientesRagu);

        platos = Stream.of(ensalada, ragu).collect(Collectors.toList());
    }

    private void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {
            });
        } catch (Exception ex) {
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    private Ingrediente getIngrediente(String name) {
        Ingrediente ingrediente = ingredientes.stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .get();
        return ingrediente;
    }
}

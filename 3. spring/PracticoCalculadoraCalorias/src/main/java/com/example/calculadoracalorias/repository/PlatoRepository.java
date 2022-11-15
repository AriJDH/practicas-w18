package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository{
    IIngredienteRepository ingredienteRepository;

    public PlatoRepository(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    List<Plato> listaPlatos = new ArrayList<>();

    @Override
    public void generarMenu(){
        Plato plato1 = new Plato("menu1", 0, generarIngredientes(), 0);
        Plato plato2 = new Plato("menu2", 0, generarIngredientes(), 0);
        Plato plato3 = new Plato("menu3", 0, generarIngredientes(), 0);
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);
        listaPlatos.add(plato3);
    }
    @Override
    public void guardarPlato(Plato plato) {
        listaPlatos.add(plato);
    }

    @Override
    public List<Plato> mostrarPlatos() {
        return listaPlatos;
    }

    public List<Ingrediente> generarIngredientes(){
        List<Ingrediente> listaIngredientes = ingredienteRepository.loadList();
        List<Ingrediente> listaIngredientesRandom = new ArrayList<>();

        for(int i=0; i<4; i++){
            listaIngredientesRandom.add(listaIngredientes.get((int) (Math.random()* listaIngredientes.size())));
        }
        return listaIngredientesRandom;
    }
}

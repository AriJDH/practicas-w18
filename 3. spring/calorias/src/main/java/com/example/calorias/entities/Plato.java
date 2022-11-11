package com.example.calorias.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Plato {
    private List<Ingrediente> ingredientes= new ArrayList<>();
    private String nombre;
    private double gramos;

    public Plato(String nombre, double gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public void addIngrediente(Ingrediente ingrediente){
        ingredientes.add(ingrediente);
    }

    public double cantidadCalorias(){
        return ingredientes.stream().mapToDouble(i->Double.valueOf(i.getCalories())*(this.gramos/100)).sum();
    }

    public Ingrediente ingredienteMasCalorico(){
        Ingrediente masCalorico = this.ingredientes.get(0);
        for (Ingrediente ingrediente:this.ingredientes
             ) {
            if(ingrediente.getCalories() > masCalorico.getCalories()){
                masCalorico = ingrediente;
            }
        }
        return masCalorico;
    }
    
}

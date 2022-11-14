package com.spring.calculadoracalorias.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Plato {
    private String nombre;
    private List<Ingrediente> listaIngredientes;

    public Integer calcularCaloriasTotales(int gramos){
        int calorias = 0;
        int gramosEstandar = listaIngredientes.size() * 100;
        int caloriasPorCantidad = 0;

        for(Ingrediente ing: listaIngredientes){
            calorias += ing.getCalories();
        }
        caloriasPorCantidad = (gramos * calorias)/gramosEstandar;
        return caloriasPorCantidad;
    }

    public Ingrediente calcularIngMaxCalorias(){
        int maxCalorias = 0;
        Ingrediente ingMaxCalorias = new Ingrediente();
        for(Ingrediente ing: listaIngredientes){
            if(ing.getCalories() > maxCalorias){
                maxCalorias = ing.getCalories();
                ingMaxCalorias = ing;
            }
        }
        return ingMaxCalorias;
    }

}
package com.calorias.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plato {

    private int idPlato;
    private String nombre;
    private List<Ingrediente> ingredientes;

}

package com.apicalorias.CalculadoraCalorias.entity;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Plato {
    private String nombre;
    private List<String> ingredientes;

}

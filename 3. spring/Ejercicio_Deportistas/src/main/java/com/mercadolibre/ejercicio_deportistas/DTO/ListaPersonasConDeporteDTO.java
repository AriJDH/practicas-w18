package com.mercadolibre.ejercicio_deportistas.DTO;

import com.mercadolibre.ejercicio_deportistas.entity.Deporte;
import com.mercadolibre.ejercicio_deportistas.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaPersonasConDeporteDTO {

    private ArrayList<String> deportista = new ArrayList<>();
    private ArrayList<Deporte> deportes = new ArrayList<>();
}
